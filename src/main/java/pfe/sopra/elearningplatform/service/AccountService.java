package pfe.sopra.elearningplatform.service;

import pfe.sopra.elearningplatform.entity.ERole;
import pfe.sopra.elearningplatform.entity.EUser;

public interface AccountService {
    public EUser saveUser( EUser user);
    public ERole saveRole(ERole role);
    public void addRoleUser(String username, String roleName);
    public EUser findEUserByUsername(String username);
    public EUser findEUserByEmail(String email);
}
