package pfe.sopra.elearningplatform.entity.activities.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.Activity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("forum")
public class Forum extends Activity {
    private String subject;
}
