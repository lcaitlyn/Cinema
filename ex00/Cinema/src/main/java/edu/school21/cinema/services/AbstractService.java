package edu.school21.cinema.services;

import edu.school21.cinema.repositories.AbstractDao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<T> {

    @Autowired
    private AbstractDao<T> dao;

    public T findById(Long id) {
        return dao.findById(id);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public void save(T entity) {
        dao.save(entity);
    }

    public void update(T entity) {
        dao.update(entity);
    }

    public void delete(T entity) {
        dao.delete(entity);
    }
}
