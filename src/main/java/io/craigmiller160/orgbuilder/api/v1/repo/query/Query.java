package io.craigmiller160.orgbuilder.api.v1.repo.query;

import java.util.List;
import java.util.Map;

/**
 * Special interface for a module that defines
 * a query of a data source. Implementations
 * can use any type of data source or mechanism
 * of accessing it that they want.
 *
 * This type of object is designed to work
 * with implementations of the Repo interface,
 * so that it has the flexibility to perform
 * any operation it may need to without
 * needing new methods added.
 *
 * Created by craigmiller on 1/10/16.
 */
public interface Query<T> {

    Map<String,Object> getParameters();

    T execute();

}
