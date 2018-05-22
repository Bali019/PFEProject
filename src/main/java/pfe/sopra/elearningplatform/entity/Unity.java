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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unityId;
    private String unityName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private int orderU;
    private String type;
    private boolean active;
    @OneToMany(mappedBy = "unity", fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<Resource> resource = new ArrayList<>();
    @OneToMany(mappedBy = "unity", fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<Activity> activity = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Unity chapter;
    @OneToMany(mappedBy = "chapter",cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<Unity> sections = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private EUser user;

    @ManyToOne
    private Formation formation;

    public Unity(String unityName, String description, EUser eUser) {
        this.unityName = unityName;
        this.description = description;
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

    @JsonIgnore
    public Formation getFormation() {
        return formation;
    }

    @JsonSetter
    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @JsonIgnore
    public Unity getChapter() {
        return chapter;
    }

    @JsonSetter
    public void setChapter(Unity chapter) {
        this.chapter = chapter;
    }
}
