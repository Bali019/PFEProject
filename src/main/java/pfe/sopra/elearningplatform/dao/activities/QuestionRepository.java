package pfe.sopra.elearningplatform.dao.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pfe.sopra.elearningplatform.entity.activities.survey.Question;

import java.util.Collection;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "SELECT q from Question q  where q.survey.activityId= ?1")
    public Collection<Question> findAllBySurvey(Long activityId);
}
