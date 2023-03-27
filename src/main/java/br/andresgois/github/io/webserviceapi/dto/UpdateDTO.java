package br.andresgois.github.io.webserviceapi.dto;

import org.springframework.data.domain.Page;
import br.andresgois.github.io.webserviceapi.model.Updates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDTO {

    private String ID;
    private String Alias;
    private String DocumentTitle;
    private String Severity;
    private String InitialReleaseDate;
    private String CurrentReleaseDate;
    private String CvrfUrl;
  
    public static Page<UpdateDTO> montaRetorno(Page<Updates> updates){
        Page<UpdateDTO> dto = updates.map( item -> convertToObjectDto(item));
        return dto;
    }
    
    public static UpdateDTO convertToObjectDto(Updates up) {
        UpdateDTO dto = new UpdateDTO();
        dto.setID(up.getID());
        dto.setAlias(up.getAlias());
        dto.setDocumentTitle(up.getDocumentTitle());
        dto.setSeverity(up.getSeverity());
        dto.setInitialReleaseDate(up.getInitialReleaseDate());
        dto.setCurrentReleaseDate(up.getCurrentReleaseDate());
        dto.setCvrfUrl(up.getCvrfUrl());
        
        return dto;
    }
}
