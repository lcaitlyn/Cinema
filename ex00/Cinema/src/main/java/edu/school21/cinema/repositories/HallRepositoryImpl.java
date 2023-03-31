package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HallRepositoryImpl implements HallRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Hall> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Hall> findAll() {
        Session session = sessionFactory.getCurrentSession();

        List<Hall> halls = session.createQuery("from Hall").getResultList();


        return halls;
    }

    @Override
    public void save(Hall entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public void update(Hall entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
