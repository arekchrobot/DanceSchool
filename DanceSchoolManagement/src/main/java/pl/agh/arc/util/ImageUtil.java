package pl.agh.arc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.arc.StoredDataProperties;
import pl.agh.arc.domain.Activity;
import pl.agh.arc.domain.Instructor;
import pl.agh.arc.domain.News;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
@Service
public class ImageUtil {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);
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
    
    public byte[] resolveImage(News news) {
        StringBuilder newsFilepath = new StringBuilder();
        newsFilepath.append(storedDataProperties.getBasePath());
        newsFilepath.append(storedDataProperties.getNewsPath());
        newsFilepath.append(news.getId());
        newsFilepath.append("/");
        newsFilepath.append(news.getImage());
        
        return resolveImage(newsFilepath.toString(), "jpg");
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

    public boolean saveImage(byte[] image, News news) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getNewsPath());
        filepath.append(news.getId());
        filepath.append("/");
        filepath.append(news.getImage());

        try {
            resolveByteArray(image, "jpg", filepath.toString());
            return true;
        } catch (IOException e) {
            logger.error("Unable to save image for news with id: " + news.getId() + " with ex: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean saveImage(byte[] image, Activity activity) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getActivityPath());
        filepath.append(activity.getId());
        filepath.append("/");
        //TODO implement intelligent save
//        filepath.append(activity.getImage());

        try {
            resolveByteArray(image, "png", filepath.toString());
            return true;
        } catch (IOException e) {
            logger.error("Unable to save image for activity with id: " + activity.getId() + " with ex: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean saveImage(byte[] image, Instructor instructor) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getInstructorPath());
        filepath.append(instructor.getId());
        filepath.append("/");
        filepath.append(instructor.getImage());

        try {
            resolveByteArray(image, "png", filepath.toString());
            return true;
        } catch (IOException e) {
            logger.error("Unable to save image for instructor with id: " + instructor.getId() + " with ex: " + e.getLocalizedMessage());
            return false;
        }
    }

    private void resolveByteArray(byte[] imageArray, String type, String filepath) throws IOException {
        InputStream is = new ByteArrayInputStream(imageArray);
        BufferedImage resolvedImage = ImageIO.read(is);

        ImageIO.write(resolvedImage, type, new File(filepath));
    }

    public void removeFile(News news) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getNewsPath());
        filepath.append(news.getId());
        filepath.append("/");
        filepath.append(news.getImage());

        removeFile(filepath.toString());
    }

    public void removeFile(Instructor instructor) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getInstructorPath());
        filepath.append(instructor.getId());
        filepath.append("/");
        filepath.append(instructor.getImage());

        removeFile(filepath.toString());
    }

    public void removeFile(Activity activity) {
        StringBuilder filepath = new StringBuilder();
        filepath.append(storedDataProperties.getBasePath());
        filepath.append(storedDataProperties.getActivityPath());
        filepath.append(activity.getId());
        filepath.append("/");
        for (String image : activity.getGallery()) {
            removeFile(filepath.toString() + image);
        }
    }

    private void removeFile(String filepath) {
        File fileToRemove = new File(filepath);

        File parent = fileToRemove.getParentFile();

        if(fileToRemove.exists()) {
            if (fileToRemove.delete()) {
                if (parent.delete()) {
                    logger.info("Succesfully removed files at path: " + filepath);
                } else {
                    logger.error("Error deleting file at path: " + parent.getAbsolutePath());
                }
            } else {
                logger.error("Cannot remove file at path: " + filepath);
            }
        } else {
            logger.error("No file exists at path: " + filepath);
        }
    }
}
