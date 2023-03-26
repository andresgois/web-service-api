package br.andresgois.github.io.webserviceapi.service;

import static br.andresgois.github.io.webserviceapi.util.Contants.SALVO_SUCESSO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper objectMapper = new ObjectMapper();
        Updates update = null;
        
        JSONArray object = Shared.stringToObject(dados);
        for (int i = 0; i < object.length(); i++) {
            update = new Updates();
            Updates up = update.create(object.getJSONObject(i).getString("ID"),
                    object.getJSONObject(i).getString("Alias"), object.getJSONObject(i).getString("DocumentTitle"),
                    object.getJSONObject(i).getString("Severity"),
                    object.getJSONObject(i).getString("InitialReleaseDate"),
                    object.getJSONObject(i).getString("CurrentReleaseDate"),
                    object.getJSONObject(i).getString("CvrfUrl"));
            // update = objectMapper.readValue(object.getJSONObject(i).toString(),
            // Updates.class);
            Boolean existeUpdate = repository.existsByIdObj(up.getIdObj());
            
            if (!existeUpdate) {
                repository.save(up);
                log.info(SALVO_SUCESSO + up.getIdObj());
            }
        }
        
    }
    
    public List<Updates> listaTodos() {
        return repository.findAll();
    }
    
}
