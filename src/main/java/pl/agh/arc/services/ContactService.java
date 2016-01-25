package pl.agh.arc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.IContactDao;
import pl.agh.arc.domain.Contact;
import pl.agh.arc.services.api.IContactService;

/**
 *
 * @author chrobota
 */
@Service
@Transactional
public class ContactService implements IContactService {

    @Autowired
    private IContactDao contactDao;
    
    public Contact getContactData() {
        return contactDao.findAll().iterator().next();
    }
}
