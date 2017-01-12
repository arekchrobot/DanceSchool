package pl.agh.arc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.NewsDao;
import pl.agh.arc.domain.News;
import pl.agh.arc.service.NewsService;
import pl.agh.arc.util.ImageUtil;
import pl.agh.arc.wrappers.NewsWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2016-07-15.
 */
@Service
@Transactional
public class NewsServiceImpl extends CrudServiceImpl<News> implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private ImageUtil imageUtil;

    @Override
    protected CrudRepository<News, Long> getRepository() {
        return newsDao;
    }

    @Override
    public NewsWrapper save(NewsWrapper newsWrapper) {
        boolean isNew = newsWrapper.getNews().isNew();
        newsWrapper.setNews(save(newsWrapper.getNews()));
        if(isNew) {
            imageUtil.saveImage(newsWrapper.getImage(), newsWrapper.getNews());
            //newsWrapper.setImage(imageUtil.resolveImage(newsWrapper.getNews()));
        }
        return newsWrapper;
    }

    @Override
    public NewsWrapper getOne(Long id) {
        NewsWrapper newsWrapper = new NewsWrapper(get(id));
        newsWrapper.setImage(imageUtil.resolveImage(newsWrapper.getNews()));
        return newsWrapper;
    }

    @Override
    public List<NewsWrapper> getAllWrappers() {
        List<NewsWrapper> wrappers = new ArrayList<>();
        newsDao.findAllByOrderByIdDesc().forEach(news -> {
            NewsWrapper newsWrapper = new NewsWrapper(news);
            newsWrapper.setImage(imageUtil.resolveImage(news));
            wrappers.add(newsWrapper);
        });
        return wrappers;
    }

    @Override
    public void delete(Long id) {
        imageUtil.removeFile(get(id));
        super.delete(id);
    }
}
