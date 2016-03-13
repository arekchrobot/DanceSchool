package pl.agh.arc.services.api;

import pl.agh.arc.domain.About;

import java.util.List;

/**
 * Created by Arek on 2016-03-13.
 */
public interface IAboutService {

    List<About> findAll();
}
