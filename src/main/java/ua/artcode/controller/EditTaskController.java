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
import java.util.List;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/app/editTaskController")
public class EditTaskController extends MainController {

    private static final Logger logger = Logger.getLogger(EditTaskController.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = taskService.readTask(Integer.parseInt(req.getParameter("id")));
        String desc = (String) req.getParameter("desc");
        Integer prorityID = Integer.parseInt((String) req.getParameter("taskPriority"));
        Integer stateID = Integer.parseInt(req.getParameter("taskState"));
        TaskPriority prority = TaskPriority.getTaskPriority(prorityID);
        TaskState state = TaskState.getTaskState(stateID);
        Integer execID = Integer.parseInt(req.getParameter("executor"));
        User exec = userService.read(execID);
        User client = (User) req.getSession().getAttribute("client");
        String spH = (String) req.getParameter("pHours");
        String seH = (String) req.getParameter("eHours");
        Integer pH = 0;
        Integer eH = 0;

        if (spH != null && spH.length() > 0) {
            pH = Integer.parseInt(spH);
        }
        if (seH != null && seH.length() > 0) {
            eH = Integer.parseInt(seH);
        }

        task.setDescription(desc);
        task.setState(state);
        task.setPriority(prority);
        task.setExecutor(exec);
        task.setPlaningHours(pH);
        task.setExecutingHours(eH);
        taskService.taskUpdate(task);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/show_task.jsp");
        req.setAttribute("task", task);
        rd.forward(req, resp);
        logger.info(client.getName() + " edit task id:" + task.getId());


    }


}
