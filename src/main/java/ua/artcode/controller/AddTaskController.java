package ua.artcode.controller;

import org.apache.log4j.Logger;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(value = "/app/addTaskController")
public class AddTaskController extends MainController {
    private static final Logger logger = Logger.getLogger("ua.artcode.controller.AddTaskController");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String desc = req.getParameter("desc");
        System.out.println(req.getParameter("taskPriority"));
        Integer prorityID = Integer.parseInt(req.getParameter("taskPriority"));

        TaskPriority prority = TaskPriority.getTaskPriority(prorityID);
        Integer execID = Integer.parseInt(req.getParameter("executor"));
        User exec = userService.read(execID);
        User client = (User) req.getSession().getAttribute("client");
        String spH = req.getParameter("pHours");
        Integer pH = 0;
        if (spH.length()>0) {
            pH = Integer.parseInt(spH);
        }

        taskService.addNew(desc, TaskState.CREATED, prority, client, exec, new Date(), null, pH, 0);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
        rd.forward(req,resp);
        logger.info(client.getName() + " add new task");



    }



}
