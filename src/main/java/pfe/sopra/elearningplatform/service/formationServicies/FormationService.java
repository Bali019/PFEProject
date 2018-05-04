package pfe.sopra.elearningplatform.service.formationServicies;

import pfe.sopra.elearningplatform.dto.FormationDTO;
import pfe.sopra.elearningplatform.entity.Formation;

import java.util.List;

public interface FormationService {

    public Formation createFormation(Formation formation);
    public Formation updateFormation(Formation formation);
    public List<Formation> getFormations();
    public Formation getFormation(Long id);
    public void deleteFormation(Long id);
    public List<Formation> searchFormation(String formationName);
    public List<FormationDTO> userFormations (String username);
    public FormationDTO getFormationById(Long id);
}
