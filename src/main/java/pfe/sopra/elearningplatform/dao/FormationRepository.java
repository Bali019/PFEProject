package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pfe.sopra.elearningplatform.dto.FormationDTO;
import pfe.sopra.elearningplatform.entity.Formation;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    @Query(value = "SELECT new pfe.sopra.elearningplatform.dto.FormationDTO( f.formationId , f.formationName ,f.description , f.creationDate, f.startDate,f.endDate, f.active, f.formationCategory, f.level) from Formation f  where f.user.username = ?1")
    public List<FormationDTO> getUserFormations(String username);
    @Query(value = "SELECT new pfe.sopra.elearningplatform.dto.FormationDTO( f.formationId , f.formationName ,f.description , f.creationDate, f.startDate,f.endDate, f.active, f.formationCategory, f.level) from Formation f  where f.formationId = ?1")
    public FormationDTO getFormationById(Long id);

}
