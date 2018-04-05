package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.EUser;

public interface EUserRepository extends JpaRepository<EUser,Long> {
    public EUser findByUsername(String username);
    public EUser findEUserByEmail(String email);
}
