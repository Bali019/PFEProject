package pfe.sopra.elearningplatform.service.activityServices.survey;

import pfe.sopra.elearningplatform.entity.activities.survey.Response;

import java.util.Collection;

public interface ResponseService {
    public Response createResponse(Response response);
    public Response updateResponse(Response response);
    public boolean deleteResponse(Long id);
    public Response getResponse(Long id);
    public Collection<Response> getAllResponses (Long idQuestion);

}
