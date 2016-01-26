package pl.agh.arc.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.News;

/**
 *
 * @author chrobota
 */
public interface INewsDao extends CrudRepository<News, Long> {
    
    List<News> findAllByOrderByIdDesc();
}
