package pfe.sopra.elearningplatform.entity.activities.survey;

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
    @ManyToOne
    private Survey survey;
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Collection<Response> responses = new ArrayList<>();
}
