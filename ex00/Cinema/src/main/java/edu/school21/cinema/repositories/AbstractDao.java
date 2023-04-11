package edu.school21.cinema.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public abstract class AbstractDao<T> {

    private final Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T findById(Long id) {
        return getSession().get(clazz, id);
    }

    public List<T> findAll() {
        CriteriaQuery<T> criteria = getSession().getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return getSession().createQuery(criteria).getResultList();
    }

    public void save(T entity) {
        getSession().persist(entity);
    }

    public void update(T entity) {
        getSession().merge(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }
}
