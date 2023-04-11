package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HallRepository implements CrudRepository<Hall> {
    private SessionFactory sessionFactory;

    @Autowired
    public HallRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Hall findById(Long id) {
        return getSession().find(Hall.class, id);
    }

    @Override
    public List<Hall> findAll() {
        return getSession().createQuery("from Hall").getResultList();
    }

    @Override
    public void save(Hall entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void update(Hall entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Long id) {
        Hall hall = findById(id);
        if (hall != null) {
            getSession().delete(hall);
        }
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
