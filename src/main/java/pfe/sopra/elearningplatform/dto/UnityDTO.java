package pfe.sopra.elearningplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnityDTO {

    private  Long unityId;
    private String unityName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private boolean active;
}
