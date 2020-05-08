package stdy.socialPoll.gateways;

import stdy.socialPoll.exceptions.EntityNotFound;
import stdy.socialPoll.models.EntityModel;
import stdy.socialPoll.utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SimpleHibernateGateway<T extends EntityModel> implements IGateway<T> {
    private EntityManager manager = EntityManagerFactoryUtil.getEntityManager();
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public SimpleHibernateGateway(){
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> all() {
        return manager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public T find(Long id) throws EntityNotFound {
        T person = manager.find(persistentClass, id);
        if (person == null)
            throw new EntityNotFound(String.format("Entity with id=%d not found", id ));
        return person;
    }

    @Override
    public void insert(T object) {
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
    }

    @Override
    public void update(T object) throws EntityNotFound {
        manager.getTransaction().begin();
        manager.merge(object);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(T object) {
        manager.getTransaction().begin();
        manager.remove(object);
        manager.getTransaction().commit();
    }
}
