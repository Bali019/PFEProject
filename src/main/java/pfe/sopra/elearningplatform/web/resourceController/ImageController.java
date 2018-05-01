package pfe.sopra.elearningplatform.web.resourceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import pfe.sopra.elearningplatform.entity.EUser;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.entity.resources.Image;
import pfe.sopra.elearningplatform.service.resourceService.imageServices.ImageService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/uploadImage2", method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile files[], @RequestPart("obj") String imageR) {
        //  logger.info("POST /images/upload");

        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {

                    Image img = new Image();//imageR;
                    img.setImage(file.getBytes());
                    img.setContentType(file.getContentType());
                    img.setResourceName("firstTest ");

                    imageService.saveImage(img);
                }
            }


        } catch (MaxUploadSizeExceededException e) {
            //logger.debug("Max upload size exceeded!");
        } catch (IOException e) {
            //logger.error("Failed to read uploaded image", e);

            throw new RuntimeException("Could not process upload. Please try again.");
        }


    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    @ResponseBody
    public boolean multiPartAdd(
            @RequestPart("imageName") @Valid String imageName,
            @RequestPart("startDate") @Valid String startDate,
            @RequestPart("endDate") @Valid String endDate,
            @RequestPart("description") @Valid String description,
            @RequestPart("active") @Valid String active,
            @RequestPart("unityId") @Valid String unityId,
            @RequestPart("file") @Valid MultipartFile files[]) {
        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    Image img = new Image();
                    System.out.println(imageName);
                    Unity u = new Unity();
                    u.setUnityId(Long.valueOf(unityId));
                    img.setUnity(u);
                    img.setActive(Boolean.parseBoolean(active));
                    img.setImage(file.getBytes());
                    img.setContentType(file.getContentType());
                    img.setResourceName(imageName);
                    img.setDescription(description);
                    //String dateString = "2011-09-09";
                    System.out.println("show date " + startDate);
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date start = formatter.parse(startDate);
                    img.setStartDate(start);
                    Date end = formatter.parse(endDate);
                    img.setEndDate(end);

                    imageService.saveImage(img);
                    return true;
                }
            }


        } catch (MaxUploadSizeExceededException e) {
            //logger.debug("Max upload size exceeded!");
        } catch (IOException e) {
            //logger.error("Failed to read uploaded image", e);

            throw new RuntimeException("Could not process upload. Please try again.");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET)
    public Image getImage(@PathVariable Long id,
                          HttpServletResponse resp) {
        // logger.info("GET /images/{}/raw", id);

        Image img = imageService.getImage(id);

        if (img == null)
            //throw new ResourceNotFoundException();

            try {
                resp.setContentType(img.getContentType());
                resp.getOutputStream().write(img.getImage());
            } catch (IOException e) {
                //logger.error("Couldn't write image to OutputStream", e);
            }
        return img;
    }


}