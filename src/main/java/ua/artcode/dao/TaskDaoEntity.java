package ua.artcode.dao;

import ua.artcode.db.EntityFactory;
import ua.artcode.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public class TaskDaoEntity implements ITaskDao {
    EntityManager entityManager = EntityFactory.getInstance();
    @Override
    public void create(Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();

    }

    @Override
    public Task findOne(Integer id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.getTransaction().commit();
        return task;
    }

    @Override
    public boolean update(Task changed) {
        entityManager.getTransaction().begin();
        entityManager.persist(changed);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer count(String queryString) {
        Query query  = entityManager.createQuery(queryString);
        List<Task> list =  query.getResultList();
        return list.size();
    }

    @Override
    public Set <Task> showTasks(String queryString, int begin) {
        Query query  = entityManager.createQuery(queryString);
        query.setFirstResult(begin);
        query.setMaxResults(15);
        List<Task> list =  query.getResultList();
        Set<Task> tasks = new LinkedHashSet<Task>();
        for (Task t : list) {
            tasks.add(t);
        }
        return tasks;

    }

    public Set <Task> showTasks(String queryString) {
        Query query  = entityManager.createQuery(queryString);
        List<Task> list =  query.getResultList();
        Set<Task> tasks = new LinkedHashSet<Task>();
        for (Task t : list) {
            tasks.add(t);
        }
        return tasks;

    }
}
