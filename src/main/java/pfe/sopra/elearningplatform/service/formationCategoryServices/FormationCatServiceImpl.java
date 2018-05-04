package pfe.sopra.elearningplatform.service.formationCategoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.FormationCategoryRepository;
import pfe.sopra.elearningplatform.entity.FormationCategory;

import java.util.List;
@Service
@Transactional
public class FormationCatServiceImpl implements FormationCategoryService {
    @Autowired
    private FormationCategoryRepository formationCategoryRepository;
    @Override
    public FormationCategory createFormationCat(FormationCategory formationCategory) {
        return formationCategoryRepository.save(formationCategory);
    }

    @Override
    public FormationCategory updateFormationCat(FormationCategory formationCategory) {
        return formationCategoryRepository.save(formationCategory);
    }

    @Override
    public List<FormationCategory> getFormationsCat() {
        return formationCategoryRepository.findAll();
    }

    @Override
    public FormationCategory getFormationCat(Long id) {
        return formationCategoryRepository.findOne(id);
    }

    @Override
    public void deleteFormationCat(Long id) {
formationCategoryRepository.delete(id);
    }
}
