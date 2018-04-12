package pfe.sopra.elearningplatform.service.activityServices;

import pfe.sopra.elearningplatform.entity.Activity;

import java.util.List;

public interface ActivityService {
    public Activity createActivity(Activity activity);
    public Activity updateActivity(Activity activity);
    public List<Activity> getAllActivity();
    public void deleteActivity(long id);
    public Activity getActivity(long id);
    public List<Activity> searchActivities(String activityName);
}
