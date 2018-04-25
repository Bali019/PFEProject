package pfe.sopra.elearningplatform.dao.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.resources.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
