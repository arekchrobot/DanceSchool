package pl.agh.arc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.Contact;
import pl.agh.arc.services.api.IContactService;

/**
 *
 * @author chrobota
 */
@RestController
public class ContactController {

    @Autowired
    private IContactService contactService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/contact", produces = "application/json;charset=UTF-8")
    public Contact getContactData() {
        return contactService.getContactData();
    }
}
