package pl.agh.arc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.arc.StoredDataProperties;
import pl.agh.arc.domain.Activity;
import pl.agh.arc.domain.Instructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
@Service
public class ImageResolver {

    @Autowired
    private StoredDataProperties storedDataProperties;

    public byte[] resolveImage(Instructor instructor) {
        StringBuilder filePath = new StringBuilder();
        filePath.append(storedDataProperties.getBasePath());
        filePath.append(storedDataProperties.getInstructorPath());
        filePath.append(instructor.getId());
        filePath.append("/");
        filePath.append(instructor.getImage());

        return resolveImage(filePath.toString(), "png");
    }

    public List<byte[]> resolveImage(Activity activity) {
        StringBuilder baseActivityPath = new StringBuilder();
        baseActivityPath.append(storedDataProperties.getBasePath());
        baseActivityPath.append(storedDataProperties.getActivityPath());
        baseActivityPath.append(activity.getId());
        baseActivityPath.append("/");

        List<byte[]> gallery = new ArrayList<>();
        for (String image : activity.getGallery()) {
            gallery.add(resolveImage(baseActivityPath.toString() + image, "png"));
        }

        return gallery;
    }

    private byte[] resolveImage(String filepath, String filetype) {
        try {
            InputStream inputStream = new FileInputStream(new File(filepath));
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, filetype, byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
