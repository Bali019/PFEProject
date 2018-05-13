package pfe.sopra.elearningplatform.web.activitiesControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.Activity;
import pfe.sopra.elearningplatform.entity.activities.survey.Question;
import pfe.sopra.elearningplatform.entity.activities.survey.Response;
import pfe.sopra.elearningplatform.entity.activities.survey.Survey;
import pfe.sopra.elearningplatform.service.activityServices.ActivityService;
import pfe.sopra.elearningplatform.service.activityServices.survey.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class ActivityRestController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private QuestionService questionService;


    @PostMapping("/createAct")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @PostMapping("/createSurvey")
    public Activity createSurvey(@RequestBody Survey survey) {
        Date d = new Date();
        Collection<Question> qs = new ArrayList<>();
        if (survey.getQuestions() != null) {
            qs = survey.getQuestions();
            survey.setQuestions(null);
            survey.setCreationDate(d);
            Survey s = (Survey) activityService.createActivity(survey);
            for (Question q : qs) {
                q.setSurvey(s);
                q.setCreationDate(d);
                Collection<Response> rs = new ArrayList<>();
                if (q.getResponses() != null) {
                    rs = q.getResponses();
                    q.setResponses(null);
                    q = questionService.createQuestion(q);
                    for (Response r : rs
                            ) {
                        r.setQuestion(q);
                        r.setCreationDate(d);
                    }
                    q.setResponses(rs);
                }
            }
            s.setQuestions(qs);
            activityService.updateActivity(s);
        }
        return activityService.createActivity(survey);
    }

    @PutMapping("/updateAct")
    public Activity updateActivity(@RequestBody Activity activity) {
        return activityService.updateActivity(activity);
    }

    @GetMapping("/getActs")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }

    @DeleteMapping("/deleteAct/{id}")
    public void deleteActivity(@PathVariable long id) {
        activityService.deleteActivity(id);
    }

    @GetMapping("/getAct/{id}")
    public Activity getActivity(@PathVariable long id) {
        return activityService.getActivity(id);
    }

    @GetMapping("/searchAct")
    public List<Activity> searchActivities(@RequestParam String activityName) {
        return activityService.searchActivities(activityName);
    }
}
