package pl.agh.arc.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.NewsDao;
import pl.agh.arc.domain.News;
import pl.agh.arc.domain.wrappers.NewsWrapper;
import pl.agh.arc.services.api.INewsService;

/**
 *
 * @author chrobota
 */
@Service
@Transactional
public class NewsService implements INewsService {

    @Autowired
    private NewsDao newsDao;
    
    @Autowired
    private ImageResolver imageResolver;
    
    public List<NewsWrapper> getAllNewsDesc() {
        return convertToWrapper(newsDao.findAllByOrderByIdDesc());
    }

    private List<NewsWrapper> convertToWrapper(List<News> newsList) {
        List<NewsWrapper> wrappers = new ArrayList<>();
        
        for (News news : newsList) {
            NewsWrapper wrapper = new NewsWrapper(news);
            wrapper.setImage(imageResolver.resolveImage(news));
            wrappers.add(wrapper);
        }
        
        return wrappers;
    }
}
