package pfe.sopra.elearningplatform.web.activitiesControllers.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.activities.survey.Question;
import pfe.sopra.elearningplatform.service.activityServices.survey.QuestionService;

import java.util.Collection;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("/updateQuestion")
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public boolean deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return true;
    }

    @GetMapping("/getQuestion/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/getAllQuestions/{id}")
    public Collection<Question> getAllQuestions(@PathVariable Long id) {
        return questionService.getAllQuestions(id);
    }
}
