package io.craigmiller160.orgbuilder.api.v1.repo;

import io.craigmiller160.orgbuilder.api.v1.model.Person;
import io.craigmiller160.orgbuilder.api.v1.repo.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO document this
 *
 * Created by craigmiller on 1/10/16.
 */
@Repository("hibPersonRepo")
public class HibPersonRepo implements Repo<Person>{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Person entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(Person entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(Person entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<Object> query(Query query) {
        //TODO figure this one out
        return null;
    }
}
