package pfe.sopra.elearningplatform.entity.activities.survey;

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
    @ManyToOne
    private Question question;
}
