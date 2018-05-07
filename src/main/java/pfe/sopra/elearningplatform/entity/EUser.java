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
public class EUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    // @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private Date dateInscription;
    @Column(unique = true)
    private String email;
    private Boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ERole> roles =new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Unity> unities = new ArrayList<>();
    private Date dateLastConnexion;

    public EUser(String username,String password) {
        this.password = password;
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }
}
