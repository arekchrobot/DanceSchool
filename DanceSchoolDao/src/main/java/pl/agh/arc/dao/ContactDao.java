package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.Contact;

/**
 *
 * @author chrobota
 */
public interface ContactDao extends CrudRepository<Contact, Long> {
    
}
