package br.andresgois.github.io.webserviceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import br.andresgois.github.io.webserviceapi.service.RestService;

@SpringBootApplication
public class WebServiceApiApplication {
    
    @Autowired 
    RestService service;
    
    @Bean
    public CommandLineRunner init(RestService service) {
        
        return args -> {
            String s = service.getService();
            System.out.println(s);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApiApplication.class, args);
	}

}
