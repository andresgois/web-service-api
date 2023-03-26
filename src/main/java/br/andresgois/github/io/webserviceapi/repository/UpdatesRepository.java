package br.andresgois.github.io.webserviceapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.andresgois.github.io.webserviceapi.model.Updates;

@Repository
public interface UpdatesRepository extends JpaRepository<Updates, String> {
    
    Boolean existsByIdObj(String idObj);
    Page<Updates> findByAlias(String alias, Pageable pag);
}
