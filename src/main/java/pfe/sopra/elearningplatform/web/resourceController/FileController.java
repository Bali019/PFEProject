package pfe.sopra.elearningplatform.web.resourceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.entity.resources.FileResource;
import pfe.sopra.elearningplatform.entity.resources.Image;
import pfe.sopra.elearningplatform.service.resourceService.ResourceServices;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileController {

    @Autowired
    private ResourceServices resourceServices;
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    @ResponseBody
    public boolean multiPartAdd(
            @RequestPart("fileName") @Valid String fileName,
            @RequestPart("startDate") @Valid String startDate,
            @RequestPart("endDate") @Valid String endDate,
            @RequestPart("description") @Valid String description,
            @RequestPart("active") @Valid String active,
            @RequestPart("unityId") @Valid String unityId,
            @RequestPart("file") @Valid MultipartFile files[]) {

        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {

                    FileResource f = new FileResource();
                    System.out.println(fileName);

                    //f.setFile();
                    File ff = new File(file.getOriginalFilename());
                    file.transferTo(ff);
                    f.setFile(ff);
                    f.setContentType(file.getContentType());
                    f.setResourceName(fileName);
                    f.setDescription(description);
                    f.setActive(Boolean.parseBoolean(active));
                    Unity u = new Unity();
                    u.setUnityId(Long.valueOf(unityId));
                    f.setUnity(u);
                    //String dateString = "2011-09-09";
                    System.out.println("show date "+ startDate);
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date start = formatter.parse(startDate);
                    f.setStartDate(start);
                    Date end = formatter.parse(endDate);
                    f.setEndDate(end);

                    //fileService.saveFile(f);
                    resourceServices.createResource(f);
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

}

