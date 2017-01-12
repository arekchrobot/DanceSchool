package pl.agh.arc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.Contact;
import pl.agh.arc.service.ContactService;
import pl.agh.arc.service.CrudService;
import pl.agh.arc.util.SessionUtil;

/**
 * Created by Arek on 2016-07-14.
 */
@RestController
@RequestMapping("/contact")
public class ContactController extends CrudRestController<Contact> {

    @Autowired
    private ContactService contactService;

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    protected CrudService<Contact> getService() {
        return contactService;
    }

    @Override
    protected SessionUtil getHttpSessionUtil() {
        return sessionUtil;
    }
}
