package pl.agh.arc.wrappers;

import pl.agh.arc.domain.News;

/**
 * Created by Arek on 2016-07-15.
 */
public class NewsWrapper {

    private News news;
    private byte[] image;

    public NewsWrapper(News news) {
        this.news = news;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
