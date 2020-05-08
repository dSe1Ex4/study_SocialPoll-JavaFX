package stdy.socialPoll.gateways;

import stdy.socialPoll.exceptions.EntityNotFound;
import stdy.socialPoll.models.EntityModel;

import java.util.List;

public interface IGateway<T extends EntityModel> {
    List<T> all();
    T find(Long id) throws EntityNotFound;
    void insert(T object);
    void update(T object) throws EntityNotFound;
    void delete(T obj);
}
