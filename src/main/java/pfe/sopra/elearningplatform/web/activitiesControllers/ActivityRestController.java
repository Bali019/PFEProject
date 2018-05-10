package pfe.sopra.elearningplatform.web.activitiesControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.Activity;
import pfe.sopra.elearningplatform.service.activityServices.ActivityService;

import java.util.List;

@RestController
public class ActivityRestController {
    @Autowired
    private ActivityService activityService;

    @PostMapping("/createAct")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
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
