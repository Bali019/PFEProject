package pfe.sopra.elearningplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.FormationCategory;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class FormationDTO {
    private  Long formationId;
    private String formationName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private boolean active;
    private FormationCategory formationCategory;
    private String level;
}
