package pfe.sopra.elearningplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.sopra.elearningplatform.entity.Resource;
import pfe.sopra.elearningplatform.service.resourceService.ResourceServices;

import java.util.List;
@RestController
public class ResourceRestController  {
    @Autowired
    private ResourceServices resourceServices;
    @PostMapping("/createRes")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceServices.createResource(resource);
    }
@PutMapping("/updateRes")
    public Resource updateResource(@RequestBody Resource resource) {
        return resourceServices.updateResource(resource);
    }
@GetMapping("/getRess")
    public List<Resource> getAllResource() {
        return resourceServices.getAllResource();
    }
@DeleteMapping("/deleteRes/{id}")
    public void deleteResource(@PathVariable long id) {
resourceServices.deleteResource(id);
    }
@GetMapping("/getRes/{id}")
    public Resource getResource(@PathVariable long id) {
        return resourceServices.getResource(id);
    }
@GetMapping("/searchRes")
    public List<Resource> searchResource(@RequestParam String resourceName) {
        return resourceServices.searchResource(resourceName);
    }
}
