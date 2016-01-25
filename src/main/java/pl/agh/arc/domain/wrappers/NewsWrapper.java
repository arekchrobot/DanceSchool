package pl.agh.arc.domain.wrappers;

import pl.agh.arc.domain.News;

/**
 *
 * @author chrobota
 */
public class NewsWrapper {

    private String title;
    private String description;
    private byte[] image;

    public NewsWrapper(News news) {
        this.title = news.getTitle();
        this.description = news.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
