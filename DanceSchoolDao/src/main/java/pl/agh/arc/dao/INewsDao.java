package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.News;

import java.util.List;

/**
 *
 * @author chrobota
 */
public interface INewsDao extends CrudRepository<News, Long> {
    
    List<News> findAllByOrderByIdDesc();
}
