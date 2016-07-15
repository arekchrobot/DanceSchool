package pl.agh.arc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.agh.arc.exceptions.RestException;
import pl.agh.arc.service.NewsService;
import pl.agh.arc.util.HttpUtil;
import pl.agh.arc.util.SessionUtil;
import pl.agh.arc.wrappers.NewsWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Arek on 2016-07-15.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    private final static Logger logger = LoggerFactory.getLogger(NewsController.class);
    protected String className = "News";

    @Autowired
    private NewsService newsService;
    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NewsWrapper> getAll(HttpServletRequest request) throws RestException {
        try {
            logger.info("Getting all " + className + " with user: " + sessionUtil.getCurrentUser(request).getUsername());
            return newsService.getAllWrappers();
        } catch (RuntimeException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RestException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpUtil.generateOriginalUrl(request));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NewsWrapper get(@PathVariable("id") Long id, HttpServletRequest request) throws RestException {
        try {
            logger.info("Getting " + className + " with id: " + id + " with user: " + sessionUtil.getCurrentUser(request).getUsername());
            return newsService.getOne(id);
        } catch (RuntimeException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RestException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpUtil.generateOriginalUrl(request));
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NewsWrapper save(@RequestBody NewsWrapper entity, HttpServletRequest request) throws RestException {
        try {
            logger.info("Saving " + className + " with id: " + entity.getNews().getId() + " with user: " + sessionUtil.getCurrentUser(request).getUsername());
            return newsService.save(entity);
        } catch (RuntimeException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RestException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpUtil.generateOriginalUrl(request), entity);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id, HttpServletRequest request) {
        logger.info("Deleting " + className + " with id: " + id + " with user: " + sessionUtil.getCurrentUser(request).getUsername());
        newsService.delete(id);
    }
}
