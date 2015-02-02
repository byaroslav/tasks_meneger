package ua.artcode.service;

import ua.artcode.dao.ITaskDao;
import ua.artcode.model.*;

import java.util.*;

public class TaskServiceImpl implements ITaskService {

    private ITaskDao taskDao;

    public TaskServiceImpl() {

    }

    public TaskServiceImpl(ITaskDao taskDao) {
        this.taskDao = taskDao;
    }


    @Override
    public void addNew(String description, TaskState state, TaskPriority priority,
                       User author, User executor, Date createDate, Date endDate,
                       int planingHours, int executingHours) {

        Task task = new Task(description, state, priority, author, executor,
                createDate, endDate, planingHours, executingHours);

        taskDao.create(task);

    }

    @Override
    public Task readTask(int id) {

        return taskDao.findOne(id);
    }

    @Override
    public void taskUpdate(Task task) {
        taskDao.update(task);
    }

    @Override
    public Set<Task> showAllTasks() {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t");
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public Set<Task> showTasks(String query, int begin) {
        Set<Task> list = taskDao.showTasks(query, begin);
        return list;
    }

    @Override
    public Set<Task> showMyExecTasks(int id) {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t where t.executor.id = " + id);
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public Set<Task> showMyCreatedTasks(int id) {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t where t.author.id = " + id);
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public String createdQueryForTasksList(Map<String, String> params) {
        String query = "SELECT t FROM Task as t";
        Set<Task> list = new LinkedHashSet<Task>();
        int sizeMap = params.size();
        int count = 0;
        if (sizeMap > 0) {
            query = query + " where ";

            for (Map.Entry entry : params.entrySet()) {
                count++;
                if (entry.getKey().equals("author") || entry.getKey().equals("executor")) {
                    query = query + "t." + entry.getKey() + ".id = " + entry.getValue();
                } else if (entry.getKey().equals("taskPriority")) {
                    Integer priorityID = Integer.parseInt((String) entry.getValue());
                    TaskPriority tp = TaskPriority.getTaskPriority(priorityID);
                    query = query + "t.priority = " + tp.getClass().getName() + "." + tp.name();
                } else if (entry.getKey().equals("taskState")) {
                    Integer priorityID = Integer.parseInt((String) entry.getValue());
                    TaskState ts = TaskState.getTaskState(priorityID);
                    query = query + "t.state = " + ts.getClass().getName() + "." + ts.name();
                }
                System.out.println("QQQQ >>>>>>>> " + entry.getKey() + " " + entry.getValue());
                if (count < sizeMap) query = query + " and ";

            }
        }


        System.out.println("QQQQ >>>>>>>> " + query);


        return query;
    }

    @Override
    public int countTasks(String query) {
        return taskDao.count(query);
    }

}
