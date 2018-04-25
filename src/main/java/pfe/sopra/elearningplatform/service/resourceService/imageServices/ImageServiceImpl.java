package pfe.sopra.elearningplatform.service.resourceService.imageServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.sopra.elearningplatform.dao.resources.ImageRepository;
import pfe.sopra.elearningplatform.entity.resources.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public void saveImage(Image image) {


        image.setCreationDate(new Date());

        try {
            image.setThumbnail(generateThumbnail(image.getImage()));
        } catch (IOException e) {
            //logger.error("Failed to generate thumbnail", e);
            throw new RuntimeException("Failed to generate thumbnail");
        }

        imageRepository.save(image);


    }

    @Override
    public Image getImage(Long id) {
        return imageRepository.findOne(id);
    }


    /**
     * Create a thumbnail for the given image
     *
     * @param image Image to generate a thumbnail of.
     *
     * @throws IOException If there is a problem parsing the image or writing the thumbnail.
     *
     * @return The thumbnail
     */
    private static byte[] generateThumbnail(byte[] image)
            throws IOException
    {
        /*
         * FIXME - this should probably be located elsewhere.
         */
        BufferedImage original = ImageIO.read(new ByteArrayInputStream(image));

        BufferedImage resize = new BufferedImage(100, 100, original.getType());

        Graphics2D g = resize.createGraphics();

        g.drawImage(original, 0, 0, 100, 100, null);
        g.dispose();

        ByteArrayOutputStream out = new ByteArrayOutputStream(1000);

        // FIXME - don't force jpg for thumbnails
        ImageIO.write(resize, "jpg", out);

        return out.toByteArray();
    }
}
