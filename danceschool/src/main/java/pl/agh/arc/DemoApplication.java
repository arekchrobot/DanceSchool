package pl.agh.arc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/static/images/nowoczesny_instruktor1.png");
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public TestClass getData() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/static/images/nowoczesny_instruktor1.png");
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            TestClass clazz = new TestClass();
            clazz.setName("blblb");
            clazz.setImage(byteArrayOutputStream.toByteArray());
            return clazz;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public TestClass2 getData2() {
        try {
            TestClass2 clazz = new TestClass2();
            
            InputStream inputStream = this.getClass().getResourceAsStream("/static/images/nowoczesny_instruktor2.png");
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            clazz.gallery.add(byteArrayOutputStream.toByteArray());
            
            InputStream inputStream2 = this.getClass().getResourceAsStream("/static/images/nowoczesny_instruktor3.png");
            BufferedImage bufferedImage2 = ImageIO.read(inputStream2);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage2, "png", byteArrayOutputStream2);
            clazz.gallery.add(byteArrayOutputStream2.toByteArray());
            
            return clazz;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class TestClass {
        private String name;
        private byte[] image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte[] getImage() {
            return image;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }
    }

    public class TestClass2 {
        public List<byte[]> gallery = new ArrayList<>();
    }
}
