package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pfe.sopra.elearningplatform.dto.UnityDTO;
import pfe.sopra.elearningplatform.entity.Unity;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;

public interface UnityRepository extends JpaRepository<Unity, Long> {
    public List<Unity> findAllByUnityNameIsContaining(String search);

    @Query(value = "SELECT new pfe.sopra.elearningplatform.dto.UnityDTO( u.unityId , u.unityName ,u.description , u.creationDate, u.startDate,u.endDate, u.active) from Unity u  where u.user.username = ?1")
    public List<UnityDTO> getUserUnities(String username);
}
