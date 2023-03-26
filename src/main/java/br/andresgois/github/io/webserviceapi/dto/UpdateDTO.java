package br.andresgois.github.io.webserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateDTO {

    private String ID;
    private String Alias;
    private String DocumentTitle;
    private String Severity;
    private String InitialReleaseDate;
    private String CurrentReleaseDate;
    private String CvrfUrl;
  
}
