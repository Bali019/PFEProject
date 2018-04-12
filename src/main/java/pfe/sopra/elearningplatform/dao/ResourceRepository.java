package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.Resource;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource,Long> {
    public List<Resource> findAllByResourceNameContains(String resname);
}
