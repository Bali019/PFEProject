package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.dto.UnityDTO;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.service.unityServices.UnityServices;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UnityRestController {


    @Autowired
    private UnityServices unityServices;

    @GetMapping("/getUnitys")
    public List<Unity> unityList() {
        return unityServices.getUnitys();
    }

    @RequestMapping(value = "/addUnity", method = RequestMethod.POST)
    public Unity save(@RequestBody Unity unity) {
        return unityServices.createUnity(unity);
    }

    @PutMapping(value = "/updateUnity")
    public Unity updateUnity(@RequestBody Unity unity) {
        return unityServices.updateUnity(unity);
    }

    @RequestMapping(value = "/searchUnity", method = RequestMethod.GET)
    public List<Unity> searchUnity(@RequestParam String unityname) {
        return unityServices.searchUnity(unityname);
    }

    @RequestMapping(value = "/deleteUnity/{id}", method = RequestMethod.DELETE)
    public void deleteUnity(@PathVariable int id) {
        long unityID = id;
        unityServices.deleteUnity(unityID);
    }

    @RequestMapping(value = "/getUnity/{id}", method = RequestMethod.GET)
    public Unity getImage(@PathVariable Long id) {
        Unity unity = unityServices.getUnity(id);
        return unity;
    }
    @RequestMapping(value = "/userUnities/{username}", method = RequestMethod.GET)
    public List<UnityDTO> userUnities(@PathVariable String username) {

        return unityServices.userUnities(username);
    }
    @RequestMapping(value = "/formationUnities/{formationId}", method = RequestMethod.GET)
    public List<UnityDTO> formationUnities(@PathVariable Long formationId) {

        return unityServices.getFormationUnities(formationId);
    }
}
