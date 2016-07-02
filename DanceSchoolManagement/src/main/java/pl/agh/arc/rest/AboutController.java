package pl.agh.arc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.About;
import pl.agh.arc.service.AboutService;
import pl.agh.arc.service.CrudService;
import pl.agh.arc.util.SessionUtil;

/**
 * Created by Arek on 2016-06-18.
 */
@RestController
@RequestMapping(value = "/about")
public class AboutController extends CrudRestController<About> {

    @Autowired
    private AboutService aboutService;

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    protected CrudService<About> getService() {
        return aboutService;
    }

    @Override
    protected SessionUtil getHttpSessionUtil() {
        return sessionUtil;
    }
}
