package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.FormationCategory;
import pfe.sopra.elearningplatform.service.formationCategoryServices.FormationCategoryService;

import java.util.List;
@RestController
public class FormationCatRestController {
    @Autowired
    private FormationCategoryService formationCategoryService;

    @PostMapping("/createFormationCat")
    public FormationCategory createFormationCat(@RequestBody FormationCategory formation) {
        return formationCategoryService.createFormationCat(formation);
    }

    @PutMapping("/updateFormationCat")
    public FormationCategory updateFormationCat(@RequestBody FormationCategory formation) {
        return formationCategoryService.updateFormationCat(formation);
    }

    @GetMapping("/getFormationsCat")
    public List<FormationCategory> getFormationsCat() {
        return formationCategoryService.getFormationsCat();
    }

    @GetMapping("/getFormationCat/{id}")
    public FormationCategory getFormationCat(@PathVariable Long id) {
        return formationCategoryService.getFormationCat(id);
    }

    @DeleteMapping("/deleteFormationCat/{id}")
    public void deleteFormationCat(@PathVariable Long id) {
        formationCategoryService.deleteFormationCat(id);
    }
}
