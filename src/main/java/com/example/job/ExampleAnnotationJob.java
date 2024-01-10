package com.example.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Gary.Tsai
 */
@Slf4j
@Component
public class ExampleAnnotationJob {

    @Scheduled(cron = "0/20 * * * * ?")
    public void example(){
        log.info(this.getClass().getSimpleName());
    }
}
