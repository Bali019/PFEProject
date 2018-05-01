package pfe.sopra.elearningplatform.web.resourceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.entity.resources.CodePanel;
import pfe.sopra.elearningplatform.service.resourceService.ResourceServices;

@RestController
public class codePanelController {
    @Autowired
    private ResourceServices resourceServices;
    @RequestMapping(value = "/addCode", method = RequestMethod.POST)
    public CodePanel save(@RequestBody CodePanel code) {


        return (CodePanel) resourceServices.createResource(code);
    }
}
