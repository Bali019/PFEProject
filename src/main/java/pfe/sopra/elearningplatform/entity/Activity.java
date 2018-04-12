package pfe.sopra.elearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long activityId;
    private String activityName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private int duration;
    private boolean active;
    @ManyToOne
    private Unity unity;

    public Activity(String activityName, String description, Unity unity) {
        this.activityName = activityName;
        this.description = description;
        this.unity = unity;
    }

    @JsonIgnore
    public Unity getUnity() {
        return unity;
    }

    @JsonSetter
    public void setUnity(Unity unity) {
        this.unity = unity;
    }
}
