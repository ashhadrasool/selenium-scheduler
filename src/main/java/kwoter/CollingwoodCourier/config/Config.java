package kwoter.CollingwoodCourier.config;

import com.mysql.cj.util.StringUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import kwoter.CollingwoodCourier.model.ChromeVersionsResponse;
import kwoter.CollingwoodCourier.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @Value("${browser.path}")
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
    public void init() throws IOException {
        if(StringUtils.isNullOrEmpty(browserPath)){
            throw new RuntimeException("Browser Path needs to be provided");
        }
        String browserVersion = Util.getBrowserVersion(browserPath);
        System.out.println("browserVersion: "+ browserVersion);

//        WebDriverManager.chromiumdriver().clearDriverCache();

        String availableVersion = Util.findNearestAvailableChromeLibraryVersion(browserVersion);


        WebDriverManager webDriverManager = WebDriverManager.chromedriver().browserVersion(availableVersion);
        webDriverManager.setup();

    }

}
