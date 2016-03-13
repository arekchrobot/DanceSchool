package pl.agh.arc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.About;
import pl.agh.arc.services.api.IAboutService;

import java.util.List;

/**
 * Created by Arek on 2016-03-13.
 */
@RestController
public class AboutController {

    @Autowired
    private IAboutService aboutService;

    @RequestMapping(method = RequestMethod.GET, value = "/about", produces = "application/json;charset=UTF-8")
    public List<About> getActivity() {
        return aboutService.findAll();
    }
}
