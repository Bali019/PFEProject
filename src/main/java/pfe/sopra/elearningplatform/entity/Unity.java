package pfe.sopra.elearningplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Unity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long unityId;
    private String unityName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private int duration;
    private boolean active;

    public Unity(String unityName, String description) {
        this.unityName = unityName;
        this.description= description;
    }
}
