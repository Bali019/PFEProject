package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pfe.sopra.elearningplatform.entity.Unity;

import javax.persistence.*;

import java.util.List;

public interface UnityRepository extends JpaRepository<Unity, Long> {
    public List<Unity> findAllByUnityNameIsContaining(String search);

@Query(value = "SELECT unityId, unityName ,description , creationDate from Unity  where user.username = ?1")
    public List<Unity> getUserUnities(String username);

}
