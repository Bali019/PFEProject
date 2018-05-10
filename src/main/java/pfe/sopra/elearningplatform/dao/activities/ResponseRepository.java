package pfe.sopra.elearningplatform.dao.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pfe.sopra.elearningplatform.entity.activities.survey.Response;

import java.util.Collection;

public interface ResponseRepository extends JpaRepository<Response,Long> {

    @Query(value = "SELECT r from Response r  where r.question.questionId= ?1")
    public Collection<Response> getAllResponse(Long id);
}
