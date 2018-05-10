package pfe.sopra.elearningplatform.service.activityServices.survey;

import pfe.sopra.elearningplatform.entity.activities.survey.Question;

import java.util.Collection;

public interface QuestionService {
    public Question createQuestion(Question question);
    public Question updateQuestion(Question question);
    public boolean deleteQuestion(Long id);
    public Question getQuestion(Long id);
    public Collection<Question> getAllQuestions (Long id);
}
