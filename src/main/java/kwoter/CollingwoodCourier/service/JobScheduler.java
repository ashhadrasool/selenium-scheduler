package kwoter.CollingwoodCourier.service;

import kwoter.CollingwoodCourier.entity.QuotesQueue;
import kwoter.CollingwoodCourier.repo.QuotesQueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobScheduler {

    @Autowired
    QuotesQueueRepository quotesQueueRepository;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private static final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    public void process() {
        try {
            List<QuotesQueue> pendingQuotes = quotesQueueRepository.findTop5ByStatusOrderById(0);

            if(pendingQuotes.size()==0){
                logger.info("No Pending Quote Jobs found");
            }

            List<QuotesQueue> inProgressQuotes = pendingQuotes.stream().map((quotesQueue) -> {
                logger.info("Marking jobs as in progress");
//                quotesQueue.setStatus(1); //todo enable
                return quotesQueue;
            }).collect(Collectors.toList());

            inProgressQuotes = quotesQueueRepository.saveAll(inProgressQuotes);

            for (QuotesQueue quote : inProgressQuotes) {
                threadPoolTaskExecutor.submit(() -> {
                    System.out.println("Running Request Id: " +quote.getRequestId());
                    Automation automation = new Automation();
                    try {
                        logger.info("Setting up browser for Request Id: "+quote.getRequestId());
                        automation.setUp();
                        logger.info("Running Automation for Request Id: "+quote.getRequestId());
                        String response = automation.runAutomation(quote.getRequest());
//                        quote.setResponse(response); //todo enable
//                        quote.setStatus(2); // Set to success //todo enable
                    } catch (Exception e) {
//                        quote.setStatus(3); // Set to failed  //todo enable
                    }finally {
                        logger.info("Completed Request Id: " +quote.getRequestId());
                        quotesQueueRepository.save(quote);
                        automation.tearDown();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
