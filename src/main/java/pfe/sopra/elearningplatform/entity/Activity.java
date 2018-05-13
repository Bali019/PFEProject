package pfe.sopra.elearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.activities.forum.Forum;
import pfe.sopra.elearningplatform.entity.activities.survey.Survey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ACT", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type_act")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "quiz", value = Survey.class),
        @JsonSubTypes.Type(name = "forum", value = Forum.class)

})
@Table(name = "activity")
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
