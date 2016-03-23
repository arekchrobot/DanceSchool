package pl.agh.arc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.AboutDao;
import pl.agh.arc.domain.About;
import pl.agh.arc.services.api.IAboutService;
import pl.agh.arc.util.IterableToListConverter;

import java.util.List;

/**
 * Created by Arek on 2016-03-13.
 */
@Service
@Transactional
public class AboutService implements IAboutService {

    @Autowired
    private AboutDao aboutDao;

    @Override
    public List<About> findAll() {
        return IterableToListConverter.convertToList(aboutDao.findAll());
    }
}
