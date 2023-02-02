package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HallRepositoryImpl implements HallRepository {
    private SessionFactory sessionFactory;

    @Override
    public Optional<Hall> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Hall> findAll() {
        return null;
    }

    @Override
    public void save(Hall entity) {

    }

    @Override
    public void update(Hall entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
