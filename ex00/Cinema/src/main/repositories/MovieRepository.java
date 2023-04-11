package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MovieRepository implements CrudRepository<Movie> {

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    public MovieRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie findById(Long id) {
        return getSession().find(Movie.class, id);
    }

    @Override
    public List<Movie> findAll() {
        return getSession().createQuery("from Movie").getResultList();
    }

    @Override
    public void save(Movie entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void update(Movie entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Long id) {
        Movie movie = findById(id);
        if (movie != null) {
            getSession().delete(movie);
        }
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
