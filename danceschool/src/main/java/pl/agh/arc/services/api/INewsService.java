package pl.agh.arc.services.api;

import java.util.List;
import pl.agh.arc.domain.wrappers.NewsWrapper;

/**
 *
 * @author chrobota
 */
public interface INewsService {
    
    List<NewsWrapper> getAllNewsDesc();
}
