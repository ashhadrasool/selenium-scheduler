package kwoter.CollingwoodCourier.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kwoter.CollingwoodCourier.entity.Quotes;
import kwoter.CollingwoodCourier.entity.QuotesQueue;
import kwoter.CollingwoodCourier.entity.RequestLog;
import kwoter.CollingwoodCourier.entity.RequestLogData;
import kwoter.CollingwoodCourier.enums.QuotesQueueStatusEnum;
import kwoter.CollingwoodCourier.enums.QuotesStatusEnum;
import kwoter.CollingwoodCourier.model.QuoteDetails;
import kwoter.CollingwoodCourier.repo.QuotesQueueRepository;
import kwoter.CollingwoodCourier.repo.QuotesRepository;
import kwoter.CollingwoodCourier.repo.RequestLogDataRepository;
import kwoter.CollingwoodCourier.repo.RequestLogRepository;
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
    QuotesRepository quotesRepository;
    @Autowired
    QuotesQueueRepository quotesQueueRepository;

    @Autowired
    RequestLogDataRepository requestLogDataRepository;

    @Autowired
    RequestLogRepository requestLogRepository;

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
                quotesQueue.setStatus(QuotesQueueStatusEnum.PROCESSING.getCode()); //todo enable
                return quotesQueue;
            }).collect(Collectors.toList());

            inProgressQuotes = quotesQueueRepository.saveAll(inProgressQuotes);

            for (QuotesQueue quotesQueue : inProgressQuotes) {
                threadPoolTaskExecutor.submit(() -> {
                    Quotes quotes = quotesRepository.findByRequestId(quotesQueue.getRequestId()).orElse(null);
                    RequestLogData requestLogData = requestLogDataRepository.findByRequestLogId(quotesQueue.getRequestId()).orElse(null);
                    RequestLog requestLog = requestLogRepository.findById(quotesQueue.getRequestId()).orElse(null);
                    System.out.println("Running Request Id: " +quotesQueue.getRequestId());
                    Automation automation = new Automation();
                    try {
                        logger.info("Setting up browser for Request Id: "+quotesQueue.getRequestId());
                        automation.setUp();
                        logger.info("Running Automation for Request Id: "+quotesQueue.getRequestId());
                        QuoteDetails quoteDetails = automation.runAutomation(quotesQueue.getRequest());

                        String jsonOutput = (new ObjectMapper()).writeValueAsString(quoteDetails);

                        quotesQueue.setResponse(jsonOutput); //todo enable
                        quotesQueue.setStatus(QuotesQueueStatusEnum.SUCCESS.getCode()); // Set to success //todo enable

                        requestLogData.setOutput(jsonOutput);

                        quotes.setStatus(QuotesStatusEnum.SUCCESS.getCode().shortValue());
                        quotes.setPremium(Double.parseDouble(quoteDetails.getPremium()));
                        quotes.setIpt(Double.parseDouble(quoteDetails.getIpt()));
                        quotes.setFeeAmount(Double.parseDouble(quoteDetails.getBrokerCommission()));
                        quotes.setExcess(Double.parseDouble(quoteDetails.getTotal()));
                        quotes.setQuoteId(quoteDetails.getQuoteNumber());

                        requestLog.setSuccess(Boolean.TRUE);

                    } catch (Exception e) {
                        quotesQueue.setStatus(QuotesQueueStatusEnum.FAIL.getCode()); // Set to failed  //todo enable
                        quotes.setStatus(QuotesStatusEnum.FAIL.getCode().shortValue());
                        requestLogData.setErrorMessage(e.getMessage());
                    }finally {

                        quotesQueueRepository.save(quotesQueue);
                        quotesRepository.save(quotes);
                        requestLogDataRepository.save(requestLogData);
                        requestLogRepository.save(requestLog);

                        logger.info("Completed Request Id: " +quotesQueue.getRequestId());
                        automation.tearDown();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
