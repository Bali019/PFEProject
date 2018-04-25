package pfe.sopra.elearningplatform.entity.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.Resource;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("image")
public class Image extends Resource {
    @Lob
    private byte[] image;

    @Basic(fetch= FetchType.LAZY)
    @Lob
    private byte[] thumbnail;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}
