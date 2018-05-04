package pfe.sopra.elearningplatform.service.formationCategoryServices;

import pfe.sopra.elearningplatform.entity.FormationCategory;

import java.util.List;

public interface FormationCategoryService {
    public FormationCategory createFormationCat(FormationCategory formation);
    public FormationCategory updateFormationCat(FormationCategory formation);
    public List<FormationCategory> getFormationsCat();
    public FormationCategory getFormationCat(Long id);
    public void deleteFormationCat(Long id);

}
