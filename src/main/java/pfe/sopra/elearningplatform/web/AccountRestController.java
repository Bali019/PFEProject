package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pfe.sopra.elearningplatform.entity.EUser;
import pfe.sopra.elearningplatform.service.AccountService;
@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public EUser register(@RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getConfirmPassword()))
            throw new RuntimeException("Mot de passe incorrect !");
        EUser userTest = accountService.findEUserByUsername(userForm.getUsername());
        //System.out.println(userForm.getUserName()+"********"+userTest.getUserName()+" *** "+ userTest.getUserId());
        if (userTest!=null)
            throw  new RuntimeException("Utilisateur existe déja");
        EUser user = new EUser(userForm.getUsername(),userForm.getPassword());
        accountService.saveUser(user);
        accountService.addRoleUser(userForm.getUsername(),"STUDENT");
        return user;
    }
}
