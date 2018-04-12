package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.dao.UnityRepository;
import pfe.sopra.elearningplatform.entity.EUser;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.service.AccountService;
import pfe.sopra.elearningplatform.service.unityServices.UnityServices;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UnityRestController {


    @Autowired
    private UnityServices unityServices;
    @GetMapping("/getUnitys")
    public List<Unity> unityList(){
       return unityServices.getUnitys();
    }

    @RequestMapping(value = "/addUnity", method = RequestMethod.POST)
    public Unity save(@RequestBody Unity unity){
        return unityServices.createUnity(unity);
    }
    @PutMapping(value = "/updateUnity")
    public Unity updateUnity(@RequestBody Unity unity){
        return unityServices.updateUnity(unity);
    }
    @RequestMapping(value = "/searchUnity",method = RequestMethod.GET)
    public List<Unity> searchUnity(@RequestParam String unityname){
        return unityServices.searchUnity(unityname);
    }
    @RequestMapping(value = "/deleteUnity/{id}", method = RequestMethod.DELETE)
    public void deleteUnity(@PathVariable int id){
        long unityID = id;
        unityServices.deleteUnity(unityID);
    }
}
