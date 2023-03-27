package br.andresgois.github.io.webserviceapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.andresgois.github.io.webserviceapi.model.Updates;

@Repository
public interface UpdatesRepository extends JpaRepository<Updates, String> {
    
    Boolean existsByID(String idObj);
    Page<Updates> findByAlias(String alias, Pageable pag);
    
    @Query(value = "select * from updates where id like CONCAT('%',:pesquisa,'%') or alias like CONCAT('%',:pesquisa,'%') or document_title like CONCAT('%',:pesquisa,'%')\r\n"
            + " or severity like CONCAT('%',:pesquisa,'%') or initial_release_date like CONCAT('%',:pesquisa,'%') or current_release_date like CONCAT('%',:pesquisa,'%')\r\n"
            + " or cvrf_url like CONCAT('%',:pesquisa,'%') ",
            countQuery = " select count(*) from updates where id like CONCAT('%',:pesquisa,'%') or alias like CONCAT('%',:pesquisa,'%') or document_title like CONCAT('%',:pesquisa,'%')\r\n"
                    + " or severity like CONCAT('%',:pesquisa,'%') or initial_release_date like CONCAT('%',:pesquisa,'%') or current_release_date like CONCAT('%',:pesquisa,'%')\r\n"
                    + " or cvrf_url like CONCAT('%',:pesquisa,'%') ",
            nativeQuery = true)
    Page<Updates> pesquisaCampo(@Param("pesquisa") String pesquisa, Pageable pag);
}
