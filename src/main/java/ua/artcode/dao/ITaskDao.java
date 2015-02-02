package ua.artcode.dao;

import ua.artcode.model.Task;

import java.util.List;
import java.util.Set;

/**
 * CRUD  (Create, Read ,Update, delete)
 */
public interface ITaskDao {

    public void create(Task task);

    public Task findOne (Integer id);

    public boolean update(Task changed);

    public void delete(Integer id);

    public Integer count(String query);

    public Set<Task> showTasks(String queryString, int begin);

    public Set<Task> showTasks(String queryString);

}
