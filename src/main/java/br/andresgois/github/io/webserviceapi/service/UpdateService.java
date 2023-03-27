package br.andresgois.github.io.webserviceapi.service;

import static br.andresgois.github.io.webserviceapi.util.Contants.SALVO_SUCESSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.andresgois.github.io.webserviceapi.dto.UpdateDTO;
import br.andresgois.github.io.webserviceapi.model.Updates;
import br.andresgois.github.io.webserviceapi.repository.UpdatesRepository;
import br.andresgois.github.io.webserviceapi.util.Shared;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UpdateService {
    
    @Autowired
    private UpdatesRepository repository;
    @Autowired
    private RestService restService;
    
    public void inserirDadosExternos() throws JSONException {
        String dados = restService.getService();
        Gson gson = (new GsonBuilder()).create();
        JSONArray object = Shared.stringToObject(dados);
        for (int i = 0; i < object.length(); i++) {
            Updates up = gson.fromJson(object.getJSONObject(i).toString(), Updates.class);
            Boolean existeUpdate = repository.existsByID(up.getID());            
            if (!existeUpdate) {
                repository.save(up);
                log.info(SALVO_SUCESSO + up.getID());
            }
        }        
    }
    
    public Page<UpdateDTO> listaTodos(String pesquisa, Pageable paginacao) {
        if(pesquisa == null || pesquisa.isEmpty()) {
             Page<Updates> updates = repository.findAll(paginacao);
             Page<UpdateDTO> updateDto = UpdateDTO.montaRetorno(updates);
             return updateDto;
        }
        Page<Updates> updates = repository.pesquisaCampo(pesquisa, paginacao);
        Page<UpdateDTO> updateDto = UpdateDTO.montaRetorno(updates);
        
        return updateDto;
    }
    
}
