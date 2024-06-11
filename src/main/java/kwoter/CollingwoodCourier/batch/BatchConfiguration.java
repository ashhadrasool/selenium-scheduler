package kwoter.CollingwoodCourier.batch;

import kwoter.CollingwoodCourier.repo.QuotesQueueRepository;
import kwoter.CollingwoodCourier.service.Automation;
import kwoter.CollingwoodCourier.tasklet.ProcessQuotesTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Value("${pool-size}")
    private int poolSize;
    @Value("${max-pool-size}")
    private int maxPoolSize;
    @Value("${queue-capacity}")
    private int queueCapacity;

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("batch_thread-");
        executor.initialize();
        return executor;
    }

    @Bean
    public Job processQuotesJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("processQuotesJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, ProcessQuotesTasklet processQuotesTasklet) {
        return new StepBuilder("step1", jobRepository)
                .tasklet(processQuotesTasklet, transactionManager)
                .build();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(taskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    @Bean
    public Automation getAutomation(){
        return new Automation();
    }
}
