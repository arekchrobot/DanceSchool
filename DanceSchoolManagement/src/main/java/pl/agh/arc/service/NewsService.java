package pl.agh.arc.service;

import pl.agh.arc.domain.News;
import pl.agh.arc.wrappers.NewsWrapper;

import java.util.List;

/**
 * Created by Arek on 2016-07-15.
 */
public interface NewsService extends CrudService<News> {

    NewsWrapper save(NewsWrapper newsWrapper);
    NewsWrapper getOne(Long id);
    List<NewsWrapper> getAllWrappers();
}
