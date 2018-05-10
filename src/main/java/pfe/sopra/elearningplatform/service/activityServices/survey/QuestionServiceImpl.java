package pfe.sopra.elearningplatform.service.activityServices.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.activities.QuestionRepository;
import pfe.sopra.elearningplatform.entity.activities.survey.Question;

import java.util.Collection;
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public boolean deleteQuestion(Long id) {
        questionRepository.delete(id);
         return true;
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public Collection<Question> getAllQuestions( Long idActivity) {
        return questionRepository.findAllBySurvey(idActivity);
    }
}
