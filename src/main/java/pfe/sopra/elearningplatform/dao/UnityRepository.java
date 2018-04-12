package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.Unity;
import javax.persistence.*;

import java.util.List;

public interface UnityRepository extends JpaRepository<Unity,Long>{
    public List<Unity> findAllByUnityNameIsContaining(String search);

}
