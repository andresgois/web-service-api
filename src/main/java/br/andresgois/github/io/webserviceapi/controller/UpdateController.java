package br.andresgois.github.io.webserviceapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.andresgois.github.io.webserviceapi.model.Updates;
import br.andresgois.github.io.webserviceapi.service.UpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/update")
@CrossOrigin("http://localhost:4200")
@Api("API de lista de contatos")
public class UpdateController {
   
    
    @Autowired
    private UpdateService service;
    
    @GetMapping
    @ApiOperation("Endpoint para lista todos os updates ")
    public ResponseEntity<List<Updates>> findAll() {
        List<Updates> list = service.listaTodos();
        return ResponseEntity.ok().body(list);
    }
}
