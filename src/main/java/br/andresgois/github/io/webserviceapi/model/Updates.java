package br.andresgois.github.io.webserviceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Updates {

    @Id
    @Column(name = "id")
    private String ID;
    
    @Column(name = "alias", nullable = true)
    private String Alias;
    
    @Column(name = "document_title", nullable = true)
    private String DocumentTitle;
    
    @Column(name = "severity", nullable = true)
    private String Severity;
    
    @Column(name = "initial_release_date", nullable = true)
    private String InitialReleaseDate;
    
    @Column(name = "current_release_date", nullable = true)
    private String CurrentReleaseDate;
    
    @Column(name = "cvrf_url", nullable = true)
    private String CvrfUrl;

}
