package pfe.sopra.elearningplatform.entity.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfe.sopra.elearningplatform.entity.Resource;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.File;
@Entity
@AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("file")
public class FileResource extends Resource {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
