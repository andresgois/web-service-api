package br.andresgois.github.io.webserviceapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Updates {
   
    private String ID;
    private String Alias;
    private String DocumentTitle;
    private String Severity;
    private String InitialReleaseDate;
    private String CurrentReleaseDate;
    private String CvrfUrl;
}
