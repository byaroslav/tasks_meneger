package ua.artcode.controller;

import org.apache.log4j.Logger;
import ua.artcode.model.Task;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;
import ua.artcode.service.ITaskService;
import ua.artcode.service.IUserService;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/app/addTaskController")
public class AddTaskController extends MainController {
    private static final Logger logger = Logger.getLogger("ua.artcode.controller.AddTaskController");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String desc = (String) req.getParameter("desc");
        System.out.println((String) req.getParameter("taskPriority"));
        Integer prorityID = Integer.parseInt((String) req.getParameter("taskPriority"));

        TaskPriority prority = TaskPriority.getTaskPriority(prorityID);
        Integer execID = Integer.parseInt((String) req.getParameter("executor"));
        User exec = userService.read(execID);
        User client = (User) req.getSession().getAttribute("client");
        String spH = (String) req.getParameter("pHours");
        Integer pH = 0;
        if (spH.length()>0) {
            pH = Integer.parseInt(spH);
        }

        taskService.addNew(desc, TaskState.CREATED, prority, client, exec, new Date(), null, pH, 0);
        PrintWriter pw = resp.getWriter();
        Set<Task> taskList = taskService.showAllTasks();
        req.setAttribute("Tasks",taskList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/view_tasks.jsp");
        rd.forward(req,resp);
        logger.info(client.getName() + " add new task");



    }



}