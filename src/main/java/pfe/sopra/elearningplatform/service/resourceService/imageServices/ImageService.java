package pfe.sopra.elearningplatform.service.resourceService.imageServices;

import org.springframework.stereotype.Service;
import pfe.sopra.elearningplatform.entity.resources.Image;

import javax.persistence.Lob;

public interface ImageService {
    public void saveImage(Image img);
    public Image getImage(Long id);
}
