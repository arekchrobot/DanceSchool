package pl.agh.arc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.ContactDao;
import pl.agh.arc.domain.Contact;
import pl.agh.arc.service.ContactService;

/**
 * Created by Arek on 2016-07-14.
 */
@Service
@Transactional
public class ContactServiceImpl extends CrudServiceImpl<Contact> implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    protected CrudRepository<Contact, Long> getRepository() {
        return contactDao;
    }
}
