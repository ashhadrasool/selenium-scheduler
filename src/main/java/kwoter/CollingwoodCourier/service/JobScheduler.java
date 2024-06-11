package kwoter.CollingwoodCourier.service;

import kwoter.CollingwoodCourier.tasklet.ProcessQuotesTasklet;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class JobScheduler {

    @Autowired
    private ProcessQuotesTasklet processQuotesTasklet;

    @Scheduled(fixedRate = 120000) // Execute every 1 minute
    public void executeProcessQuotesTasklet() {
        try {
            // Create dummy StepContribution and ChunkContext
            StepContribution contribution = new StepContribution(new StepExecution("dummyStep", new JobExecution(123L), 456L));
            ChunkContext chunkContext = new ChunkContext(null);
            processQuotesTasklet.execute(contribution, chunkContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
