package pfe.sopra.elearningplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.sopra.elearningplatform.entity.FormationCategory;

public interface FormationCategoryRepository extends JpaRepository<FormationCategory,Long> {
}
