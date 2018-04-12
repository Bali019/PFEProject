package pfe.sopra.elearningplatform.service.resourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.ResourceRepository;
import pfe.sopra.elearningplatform.entity.Resource;

import java.util.List;
@Service
@Transactional
public class ResourceServiceImpl implements ResourceServices {
    @Autowired
    private ResourceRepository resourceRepository;
    @Override
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource updateResource(Resource resource) {
        Resource r = resourceRepository.findOne(resource.getResourceId());
        resource.setCreationDate(r.getCreationDate());
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResource() {
        return resourceRepository.findAll();
    }

    @Override
    public void deleteResource(long id) {
resourceRepository.delete(id);
    }

    @Override
    public Resource getResource(long id) {
        return resourceRepository.findOne(id);
    }

    @Override
    public List<Resource> searchResource(String resourceName) {
        return resourceRepository.findAllByResourceNameContains(resourceName);
    }
}
