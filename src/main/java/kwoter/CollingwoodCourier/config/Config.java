package kwoter.CollingwoodCourier.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class Config {
    @Value("${executor-service.pool-size}")
    private int poolSize;
    @Value("${executor-service.max-pool-size}")
    private int maxPoolSize;
    @Value("${executor-service.queue-capacity}")
    private int queueCapacity;

    @Value("${task-scheduler.pool-size}")
    private int taskSchedulerPoolSize;

    @Value("${browser-path}")
    private String browserPath;
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(taskSchedulerPoolSize);
        return threadPoolTaskScheduler;
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("batch_thread-");
        return executor;
    }

    public String getBrowserPath() {
        return browserPath;
    }

    public void setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
    }

    @PostConstruct
    public void init() {
        System.setProperty("browser-path", browserPath);
    }

}
