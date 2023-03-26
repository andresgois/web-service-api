package br.andresgois.github.io.webserviceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.andresgois.github.io.webserviceapi.service.RestService;
import br.andresgois.github.io.webserviceapi.service.UpdateService;

@SpringBootApplication
public class WebServiceApiApplication {
    
    @Autowired 
    private RestService service;
    
    @Autowired
    private UpdateService updateService;
    
    @Bean
    public CommandLineRunner init(RestService service) {
        
        return args -> {
            updateService.inserirDadosExternos();
            /*String s = service.getService();
            System.out.println(s);*/
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApiApplication.class, args);
	}

}
