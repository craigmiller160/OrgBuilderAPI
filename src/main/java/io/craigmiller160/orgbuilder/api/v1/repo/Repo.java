package io.craigmiller160.orgbuilder.api.v1.repo;

import io.craigmiller160.orgbuilder.api.v1.repo.query.Query;

import java.util.List;

/**
 * TODO document this
 *
 * Created by craigmiller on 1/10/16.
 */
public interface Repo<T> {

    void insert(T entity);

    void update(T entity);

    void delete(T entity);

    List<Object> query(Query query);

}
