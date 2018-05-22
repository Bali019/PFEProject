package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.dao.FormationGoalRepository;
import pfe.sopra.elearningplatform.dto.FormationDTO;
import pfe.sopra.elearningplatform.entity.Formation;
import pfe.sopra.elearningplatform.entity.FormationGoal;
import pfe.sopra.elearningplatform.service.formationServicies.FormationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class FormationRestController {
    @Autowired
    private FormationService formationService;
    @Autowired
    private FormationGoalRepository formationGoalService;

    @PostMapping("/createFormation")
    public Formation createFormation(@RequestBody Formation formation) {
        Date d = new Date();
        Collection<FormationGoal> goals;
        if (formation.getFormationGoals() != null) {
            goals = formation.getFormationGoals();
            formation.setFormationGoals(null);
            formation.setCreationDate(d);
            formation = formationService.createFormation(formation);
            Collection<FormationGoal> goals2=new ArrayList<>();
          for (FormationGoal fg : goals) {
                if ((fg.getGoal()!=null)&& (fg.getGoal()!="")){
                    fg.setFormation(formation);
                    goals2.add(fg);
                    System.out.println(fg.getGoal() +" <================== 1");
                }
                else{

                    System.out.println(fg.getGoal() +" <================== 2");}
            }
            formation.setFormationGoals(goals2);
            return formationService.updateFormation(formation);
        }
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
