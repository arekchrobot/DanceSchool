package pl.agh.arc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.AboutDao;
import pl.agh.arc.domain.About;
import pl.agh.arc.service.AboutService;

import java.io.Serializable;

/**
 * Created by Arek on 2016-06-18.
 */
@Service
@Transactional
public class AboutServiceImpl extends CrudServiceImpl<About> implements AboutService {

    @Autowired
    private AboutDao aboutDao;

    @Override
    protected CrudRepository<About, Long> getRepository() {
        return aboutDao;
    }
}
