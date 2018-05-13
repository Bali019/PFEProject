package pfe.sopra.elearningplatform.entity.activities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    private String content;
    private String questionType;
    private int rsponseNumber;
    private boolean flag;
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_activity_id")
    private Survey survey;
    @OneToMany(mappedBy = "question", orphanRemoval = true, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Response> responses = new ArrayList<>();
@JsonIgnore
    public Survey getSurvey() {
        return survey;
    }
@JsonSetter
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
