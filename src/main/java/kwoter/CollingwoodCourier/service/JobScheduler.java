package kwoter.CollingwoodCourier.service;

import kwoter.CollingwoodCourier.entity.QuotesQueue;
import kwoter.CollingwoodCourier.repo.QuotesQueueRepository;
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

    public void process() {
        try {
            List<QuotesQueue> pendingQuotes = quotesQueueRepository.findTop5ByStatusOrderById(0);

            List<QuotesQueue> inProgressQuotes = pendingQuotes.stream().map((quotesQueue) -> {
//                quotesQueue.setStatus(1); //todo enable
                return quotesQueue;
            }).collect(Collectors.toList());

            inProgressQuotes = quotesQueueRepository.saveAll(inProgressQuotes);

            for (QuotesQueue quote : inProgressQuotes) {
                threadPoolTaskExecutor.submit(() -> {
                    Automation automation = new Automation();
                    try {
                        automation.setUp();
                        String response = automation.runAutomation(quote.getRequest());
//                        quote.setResponse(response); //todo enable
//                        quote.setStatus(2); // Set to success //todo enable
                    } catch (Exception e) {
//                        quote.setStatus(3); // Set to failed  //todo enable
                    }finally {
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
