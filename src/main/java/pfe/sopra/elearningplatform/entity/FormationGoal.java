package pfe.sopra.elearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;
    private String goal;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Formation formation;

    @JsonIgnore
    public Formation getFormation() {
        return formation;
    }

    @JsonSetter
    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
