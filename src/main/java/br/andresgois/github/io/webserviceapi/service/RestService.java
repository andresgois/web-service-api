package br.andresgois.github.io.webserviceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.andresgois.github.io.webserviceapi.config.SocketConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Service
public class RestService {
    
    @Autowired
    private SocketConfig socketConfig;

    
    public String getService() {
        log.info("============= CONSULTANDO ATUALIZAÇÕES =============");
        WebClient.Builder builder = WebClient.builder();
        String retorno = builder.build()
                .get()
                .uri(socketConfig.getWebhost())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return retorno;
    }
    
}
