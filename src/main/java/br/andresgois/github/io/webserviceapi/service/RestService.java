package br.andresgois.github.io.webserviceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.andresgois.github.io.webserviceapi.config.SocketConfig;
import br.andresgois.github.io.webserviceapi.util.Shared;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Service
public class RestService {
    
    @Autowired
    private SocketConfig socketConfig;

    
    public String getService() {
        log.info("============= WEB-SERVICE =============");
        WebClient.Builder builder = WebClient.builder();
        Shared.stringToObject("{\"@odata.context\":\"https://msrc-cvrf-wcen.azurewebsites.net/odata/$metadata#updates\",\"value\":[{\"ID\":\"2016-Apr\",\"Alias\":\"2016-Apr\",\"DocumentTitle\":\"April 2016 Security Updates\",\"Severity\":null,\"InitialReleaseDate\":\"2016-04-12T07:00:00Z\",\"CurrentReleaseDate\":\"2018-04-10T07:00:00Z\",\"CvrfUrl\":\"https://api.msrc.microsoft.com/cvrf/v2.0/document/2016-Apr\"},{\"ID\":\"2016-Aug\",\"Alias\":\"2016-Aug\",\"DocumentTitle\":\"August 2016 Security Updates\",\"Severity\":null,\"InitialReleaseDate\":\"2016-08-09T07:00:00Z\",\"CurrentReleaseDate\":\"2017-09-12T07:00:00Z\",\"CvrfUrl\":\"https://api.msrc.microsoft.com/cvrf/v2.0/document/2016-Aug\"}]}");
        String retorno = builder.build()
                .get()
                .uri(socketConfig.getWebhost())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return retorno;
    }
    
}
