package br.andresgois.github.io.webserviceapi.config;

import static br.andresgois.github.io.webserviceapi.util.Contants.*;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import br.andresgois.github.io.webserviceapi.service.UpdateService;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@Slf4j
public class ConfigSchedule {
    
    @Autowired
    private UpdateService updateService;
    
    @Scheduled(cron = "0 0/5 * * * *")
    public void sendMessage() {
        System.out.println(LocalDateTime.now()+ ": Schedule");
        try {
            updateService.inserirDadosExternos();
        } catch (JSONException e) {
            log.error(ERRO_SCHEDULE, e.getMessage());
        }
    }
}
