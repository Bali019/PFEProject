package pfe.sopra.elearningplatform.entity.activities.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.Activity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("quiz")
public class Survey extends Activity {
    private String type;
    private int questionNumber;
    @OneToMany(mappedBy = "survey", fetch = FetchType.EAGER)
    private Collection<Question> questions = new ArrayList<>();
}