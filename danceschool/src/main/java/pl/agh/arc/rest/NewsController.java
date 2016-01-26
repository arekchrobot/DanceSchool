package pl.agh.arc.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.wrappers.NewsWrapper;
import pl.agh.arc.services.api.INewsService;

/**
 *
 * @author chrobota
 */
@RestController
public class NewsController {

    @Autowired
    private INewsService newsService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/news", produces = "application/json;charset=UTF-8")
    public List<NewsWrapper> getAllNews() {
        return newsService.getAllNewsDesc();
    }
}
