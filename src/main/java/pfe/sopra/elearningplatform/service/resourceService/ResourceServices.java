package pfe.sopra.elearningplatform.service.resourceService;

import pfe.sopra.elearningplatform.entity.Resource;

import java.util.List;

public interface ResourceServices {
    public Resource createResource(Resource resource);
    public Resource updateResource(Resource resource);
    public List<Resource> getAllResource();
    public void deleteResource(long id);
    public Resource getResource(long id);
    public List<Resource> searchResource(String resourceName);
}
