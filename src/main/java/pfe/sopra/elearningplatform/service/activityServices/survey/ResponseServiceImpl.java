package pfe.sopra.elearningplatform.service.activityServices.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.ResourceRepository;
import pfe.sopra.elearningplatform.dao.activities.ResponseRepository;
import pfe.sopra.elearningplatform.entity.activities.survey.Response;

import java.util.Collection;
@Service
@Transactional
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response updateResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public boolean deleteResponse(Long id) {
        responseRepository.delete(id);
        return true;
    }

    @Override
    public Response getResponse(Long id) {
        return responseRepository.findOne(id);
    }

    @Override
    public Collection<Response> getAllResponses(Long idQ) {
        return responseRepository.getAllResponse(idQ);
    }
}
