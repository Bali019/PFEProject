package pfe.sopra.elearningplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.EUserRepository;
import pfe.sopra.elearningplatform.dao.RoleRepository;
import pfe.sopra.elearningplatform.entity.ERole;
import pfe.sopra.elearningplatform.entity.EUser;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //cryptage d password
    @Autowired
    private EUserRepository eUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public EUser saveUser(EUser user) {
        String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return eUserRepository.save(user);
    }

    @Override
    public ERole saveRole(ERole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleUser(String username, String roleName) {
ERole role = roleRepository.findERoleByRoleName(roleName);
EUser user = eUserRepository.findByUsername(username);
user.getRoles().add(role);
    }

    @Override
    public EUser findEUserByUsername(String username) {
        return eUserRepository.findByUsername(username);
    }

    @Override
    public EUser findEUserByEmail(String email) {
        return eUserRepository.findEUserByEmail(email);
    }

    @Override
    public EUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        EUser u = findEUserByUsername(currentPrincipalName);
        System.out.println("username Test 17:15 "+u.getUsername());
        return u;
    }

    @Override
    public EUser updateUser(EUser user) {
        return eUserRepository.save(user);
    }
}
