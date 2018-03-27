package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.ERole;

public interface RoleRepository extends JpaRepository<ERole,Long> {
    public ERole findERoleByRoleName(String roleName);
}
