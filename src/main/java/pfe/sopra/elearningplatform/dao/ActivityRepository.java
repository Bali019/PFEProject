package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    public List<Activity> findAllByActivityNameContains(String actN);

}
