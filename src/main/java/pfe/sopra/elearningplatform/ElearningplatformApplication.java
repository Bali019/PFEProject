package pfe.sopra.elearningplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pfe.sopra.elearningplatform.dao.EUserRepository;
import pfe.sopra.elearningplatform.dao.RoleRepository;
import pfe.sopra.elearningplatform.dao.UnityRepository;
import pfe.sopra.elearningplatform.entity.ERole;
import pfe.sopra.elearningplatform.entity.EUser;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.service.AccountService;
import pfe.sopra.elearningplatform.service.unityServices.UnityServices;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ElearningplatformApplication implements CommandLineRunner {
	@Autowired
	private UnityRepository unityRepository;
    @Autowired
	private AccountService accountService;
    @Autowired
    private UnityServices unityServices;
	public static void main(String[] args) {
		SpringApplication.run(ElearningplatformApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE(){
		return  new BCryptPasswordEncoder();
}
	@Override
	public void run(String... args) throws Exception {
	//	EUser uu = new EUser("test","123");
	//	Stream.of("HR Access","Sopra Banking","Sopra HR").forEach(u->{
	//		unityRepository.save(new Unity(u,"vide",uu));
	//	});
	/*	Stream.of("admin","Bali","Majdi").forEach(u->
		accountService.saveUser(new EUser(u,"123")));
        Stream.of("ADMIN","STUDENT","FORMER").forEach(r->
                accountService.saveRole(new ERole(r,new Date())));
        accountService.addRoleUser("admin","ADMIN");
        accountService.addRoleUser("Bali","STUDENT");
        accountService.addRoleUser("Majdi","STUDENT");
        accountService.addRoleUser("Bali","ADMIN");
/*		unityRepository.findAll().forEach(u->{
			System.out.println(u.getUnityName()+" Date "+u.getCreationDate());
		}); */
		List<Unity> unities = unityServices.searchUnity("be");
		for (Unity u: unities) {
			System.out.println("Unity Test service search "+ u.getUnityName());

		}

	}
}
