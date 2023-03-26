package br.andresgois.github.io.webserviceapi.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ConfigSchedule {
    
    
    @Scheduled(cron = "0 0/5 * * * *")
    public void sendMessage() {
        System.out.println(LocalDateTime.now()+ ": Schedule");
    }
}
