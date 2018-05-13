package pfe.sopra.elearningplatform.entity.activities.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long responseId;
    private String responseContent;
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonIgnore
    public Question getQuestion() {
        return question;
    }

    @JsonSetter
    public void setQuestion(Question question) {
        this.question = question;
    }
}
