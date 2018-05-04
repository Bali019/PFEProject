package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.dto.FormationDTO;
import pfe.sopra.elearningplatform.entity.Formation;
import pfe.sopra.elearningplatform.service.formationServicies.FormationService;

import java.util.List;

@RestController
public class FormationRestController {
    @Autowired
    private FormationService formationService ;
    @PostMapping("/createFormation")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.createFormation(formation);
    }
    @PutMapping("/updateFormation")
    public Formation updateFormation(@RequestBody Formation formation) {
        return formationService.updateFormation(formation);
    }
    @GetMapping("/getFormations")
    public List<Formation> getFormations() {
        return formationService.getFormations();
    }
    @GetMapping("/getFormation/{id}")
    public Formation getFormation(@PathVariable Long id) {
        return formationService.getFormation(id);
    }
    @DeleteMapping("/deleteFormation/{id}")
    public void deleteFormation(@PathVariable Long id) {
formationService.deleteFormation(id);
    }

    public List<Formation> searchFormation(String formationName) {
        return null;
    }

    @RequestMapping(value = "/userFormations/{username}", method = RequestMethod.GET)
    public List<FormationDTO> userFormations(@PathVariable String username) {
        return formationService.userFormations(username);
    }
    @RequestMapping(value = "/getFormationsById/{id}", method = RequestMethod.GET)
    public FormationDTO getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id);
    }
}
