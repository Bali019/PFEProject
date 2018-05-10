package pfe.sopra.elearningplatform.web.activitiesControllers.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pfe.sopra.elearningplatform.entity.activities.survey.Response;
import pfe.sopra.elearningplatform.service.activityServices.survey.ResponseService;

import java.util.Collection;
@RestController
public class ResponseController{
    @Autowired
    private ResponseService responseService;
    public Response createResponse(Response response) {
        return null;
    }

    public Response updateResponse(Response response) {
        return null;
    }

    public boolean deleteResponse(Long id) {
        return false;
    }

    public Response getResponse(Long id) {
        return null;
    }

    public Collection<Response> getAllResponses(Long idQuestion) {
        return null;
    }
}
