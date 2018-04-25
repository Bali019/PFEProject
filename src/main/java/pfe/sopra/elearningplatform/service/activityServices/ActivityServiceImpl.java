package pfe.sopra.elearningplatform.service.activityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.ActivityRepository;
import pfe.sopra.elearningplatform.entity.Activity;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity createActivity(Activity activity) {
        activity.setCreationDate(new Date());
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        Activity act = activityRepository.findOne(activity.getActivityId());
        activity.setCreationDate(act.getCreationDate());
        activity.setUnity(act.getUnity());
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivity() {
        return activityRepository.findAll();
    }

    @Override
    public void deleteActivity(long id) {
        activityRepository.delete(id);
    }

    @Override
    public Activity getActivity(long id) {
        return activityRepository.findOne(id);
    }

    @Override
    public List<Activity> searchActivities(String activityName) {
        return activityRepository.findAllByActivityNameContains(activityName);
    }
}
