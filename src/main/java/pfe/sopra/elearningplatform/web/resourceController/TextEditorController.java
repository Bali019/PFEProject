package pfe.sopra.elearningplatform.web.resourceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.entity.resources.TextField;
import pfe.sopra.elearningplatform.service.resourceService.ResourceServices;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TextEditorController {
    @Autowired
    private ResourceServices resourceServices;
    @RequestMapping(value = "/addText", method = RequestMethod.POST)
    public TextField save(@RequestBody TextField text) {
        Unity u = new Unity();
        return (TextField) resourceServices.createResource(text);
    }
    @RequestMapping(value = "/getText/{id}", method = RequestMethod.GET)
    public TextField getImage(@PathVariable Long id) {
        // logger.info("GET /images/{}/raw", id);

        TextField text = (TextField) resourceServices.getResource(id);


        return text;
    }
}
