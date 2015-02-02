package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Yaroslav on 21.01.2015.
 */
@WebServlet(value = "/app/page")
public class PageController extends MainController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = (String)req.getSession().getAttribute("query");
        Integer beg = Integer.parseInt(req.getParameter("beg")) - 1;
        Set<Task> tasks = taskService.showTasks(query,beg);
        req.setAttribute("Tasks",tasks);

//        resp.sendRedirect("err.html");
        req.getRequestDispatcher("/WEB-INF/pages/view_tasks2.jsp?query="+query).forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
