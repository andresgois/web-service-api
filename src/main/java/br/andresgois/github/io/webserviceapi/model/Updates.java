package br.andresgois.github.io.webserviceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Updates {
    
    @Id
    @SequenceGenerator(name = "sq_id_updates", sequenceName = "sq_id_updates", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_updates")
    @Column(name = "id", updatable = false)
    private Long identificador;
    
    @Column(name = "id_obj")
    private String idObj;
    
    @Column(name = "alias", nullable = true)
    private String alias;
    
    @Column(name = "document_title", nullable = true)
    private String documentTitle;
    
    @Column(name = "severity", nullable = true)
    private String severity;
    
    @Column(name = "initial_release_date", nullable = true)
    private String initialReleaseDate;
    
    @Column(name = "current_release_date", nullable = true)
    private String currentReleaseDate;
    
    @Column(name = "cvrf_url", nullable = true)
    private String cvrfUrl;
    
    public Updates create(String id, String alias, String documentTitl, String severit, String initialReleaseDate,
            String currentReleaseDate, String cvrfUrl) {
        Updates update = new Updates();
        update.setIdObj(id);
        update.setAlias(alias);
        update.setDocumentTitle(documentTitl);
        update.setSeverity(severit);
        update.setInitialReleaseDate(initialReleaseDate);
        update.setCurrentReleaseDate(currentReleaseDate);
        update.setCvrfUrl(cvrfUrl);
        
        return update;
    }
}
