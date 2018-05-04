package pfe.sopra.elearningplatform.service.formationServicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.FormationRepository;
import pfe.sopra.elearningplatform.dto.FormationDTO;
import pfe.sopra.elearningplatform.entity.Formation;

import java.util.List;

@Service
@Transactional
public class FormationServiceImp implements FormationService{
    @Autowired
    private FormationRepository formationRepository;
    @Override
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> getFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormation(Long id) {
        return formationRepository.findOne(id);
    }

    @Override
    public void deleteFormation(Long id) {
formationRepository.delete(id);
    }

    @Override
    public List<Formation> searchFormation(String formationName) {
        return null;
    }

    @Override
    public List<FormationDTO> userFormations(String username) {
        return formationRepository.getUserFormations(username);
    }

    @Override
    public FormationDTO getFormationById(Long id) {
        return formationRepository.getFormationById(id);
    }
}
