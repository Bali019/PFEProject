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
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Unity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long unityId;
    private String unityName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private int duration;
    private boolean active;
    @OneToMany(mappedBy = "unity",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Resource> resource = new ArrayList<>();
    @OneToMany(mappedBy = "unity",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Collection<Activity> activity = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private EUser user;

    public Unity(String unityName, String description, EUser eUser) {
        this.unityName = unityName;
        this.description= description;
        this.user = eUser;
    }
    @JsonIgnore
    public EUser getUser() {
        return user;
    }
    @JsonSetter
    public void setUser(EUser user) {
        this.user = user;
    }
}
