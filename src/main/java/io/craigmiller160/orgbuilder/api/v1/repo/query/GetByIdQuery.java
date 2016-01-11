package io.craigmiller160.orgbuilder.api.v1.repo.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO document this
 *
 * Created by craigmiller on 1/10/16.
 */
public abstract class GetByIdQuery<T> implements Query<T> {

    private static final String ID = "ID";

    private final Long id;

    public GetByIdQuery(Long id){
        this.id = id;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String,Object> params = new HashMap<>();
        params.put(ID, id);
        return params;
    }
}
