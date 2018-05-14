package pfe.sopra.elearningplatform.entity;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formationId;
    private String formationName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private int duration;
    private boolean active;
    private String level;
    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST,  CascadeType.REMOVE})
    private Collection<Unity> unities = new ArrayList<>();
    @ManyToOne
    private FormationCategory formationCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private EUser user;

    @JsonIgnore
    public EUser getUser() {
        return user;
    }

    @JsonSetter
    public void setUser(EUser user) {
        this.user = user;
    }
}
