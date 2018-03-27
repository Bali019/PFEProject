package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pfe.sopra.elearningplatform.dao.UnityRepository;
import pfe.sopra.elearningplatform.entity.Unity;


import java.util.List;

@RestController
public class UnityRestController {
    @Autowired
    private UnityRepository unityRepository;
    @GetMapping("/unitys")
    public List<Unity> unityList(){
        return unityRepository.findAll();
    }
    @PostMapping("/unitys")
    public Unity save(@RequestBody Unity unity){
        return unityRepository.save(unity);
    }
}
