package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;

import java.util.List;
import java.util.Optional;

public interface HallRepository extends CrudRepository<Hall> {
    Optional<Hall> findById(Long id);
    List<Hall> findAll();
    void save(Hall entity);
    void update(Hall entity);
    void delete(Long id);
}
