package kwoter.CollingwoodCourier.tasklet;

import kwoter.CollingwoodCourier.QuotesQueue;
import kwoter.CollingwoodCourier.repo.QuotesQueueRepository;
import kwoter.CollingwoodCourier.service.Automation;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProcessQuotesTasklet implements Tasklet {

    private QuotesQueueRepository quotesQueueRepository;

    private Automation automation;

    public ProcessQuotesTasklet(QuotesQueueRepository quotesQueueRepository, Automation automation) {
        this.quotesQueueRepository = quotesQueueRepository;
        this.automation = automation;

        this.automation.setUp();
    }

    private String processQuote(String request) {
        // Your processing logic here
        automation.runAutomation(request);
        return "Processed: " + request;
    }

    @Override
    @Transactional
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<QuotesQueue> newQuotes = quotesQueueRepository.findByStatus(0);

        for (QuotesQueue quote : newQuotes) {
            // Set to processing
            quote.setStatus(1);
            quotesQueueRepository.save(quote);

            try {
                // Simulate processing
                String response = processQuote(quote.getRequest());

                quote.setResponse(response);
//                quote.setStatus(2); // Set to success
            } catch (Exception e) {
//                quote.setStatus(3); // Set to failed
            }

            quotesQueueRepository.save(quote);
        }

        return RepeatStatus.FINISHED;
    }
}
