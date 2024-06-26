package kwoter.CollingwoodCourier;

import kwoter.CollingwoodCourier.service.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    JobScheduler jobScheduler;
    @Value("${task-scheduler.time-in-seconds}")
    private int scheduleAfterTimeInMinutes;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        threadPoolTaskScheduler.scheduleAtFixedRate(
                () -> jobScheduler.process(),
                Duration.ofSeconds(scheduleAfterTimeInMinutes)
        );
    }
}
