package pfe.sopra.elearningplatform.entity.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.Resource;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Blob;
@Entity
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("image")
public class Image extends Resource {
    public Blob image ;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
