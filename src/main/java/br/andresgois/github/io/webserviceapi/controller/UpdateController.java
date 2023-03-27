package br.andresgois.github.io.webserviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.andresgois.github.io.webserviceapi.dto.UpdateDTO;
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
    public Page<UpdateDTO> findAll(
            @RequestParam(required = false) String pesquisa,
            @PageableDefault(size = 10) Pageable paginacao) {
            return service.listaTodos(pesquisa, paginacao);
    }
}
