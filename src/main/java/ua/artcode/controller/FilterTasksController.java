package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.service.ITaskService;
import ua.artcode.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;

/**
 * Created by Yaroslav on 19.01.2015.
 */
@WebServlet(value = "/app/filterTasks")
public class FilterTasksController extends MainController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = new HashMap<String, String>();
        String executor = req.getParameter("executor");
        String author = req.getParameter("author");
        String taskPriority = req.getParameter("taskPriority");
        String taskState = req.getParameter("taskState");

        if (!"0".equals(executor)) params.put("executor", executor);
        if (!"0".equals(author)) params.put("author", author);
        if (!"0".equals(taskPriority)) params.put("taskPriority", taskPriority);
        if (!"0".equals(taskState)) params.put("taskState", taskState);

        String query = taskService.createdQueryForTasksList(params);
        int numberOfTasks = taskService.countTasks(query);
        req.getSession().setAttribute("numberOfTasks", numberOfTasks);
        req.getSession().setAttribute("query",query);
        req.getRequestDispatcher("/app/page?beg=1&end=11").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
