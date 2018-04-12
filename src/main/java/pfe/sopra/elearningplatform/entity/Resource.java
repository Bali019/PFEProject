package pfe.sopra.elearningplatform.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.resources.CodePanel;
import pfe.sopra.elearningplatform.entity.resources.FileResource;
import pfe.sopra.elearningplatform.entity.resources.Image;
import pfe.sopra.elearningplatform.entity.resources.TextField;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_RES",discriminatorType = DiscriminatorType.STRING,length = 5)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type_res")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "code",value = CodePanel.class),
        @JsonSubTypes.Type(name = "file",value = FileResource.class),
        @JsonSubTypes.Type(name = "image",value = Image.class),
        @JsonSubTypes.Type(name = "text",value = TextField.class)
})
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resourceId;
    private String resourceName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private  int duration;
    private boolean active;
    @ManyToOne
    private Unity unity;
}
