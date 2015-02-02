package ua.artcode.controller;

import ua.artcode.model.*;
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
import java.util.Date;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/app/addComment")
public class AddCommentController extends MainController {

    public static final String WEB_INF_PAGES_SHOW_TASK_JSP = "/WEB-INF/pages/show_task.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Task task = taskService.readTask(Integer.parseInt(req.getParameter("id")));
        String message = (String) req.getParameter("comment");
        User client = (User) req.getSession().getAttribute("client");

        Comment comment = new Comment();
        comment.setAuthor(client);
        comment.setMessage(message);
        comment.setCreateDate(new Date());
        comment.setTask(task);
        task.getComments().add(comment);

        taskService.taskUpdate(task);

        req.setAttribute("task",task);

        RequestDispatcher rd = req.getRequestDispatcher(WEB_INF_PAGES_SHOW_TASK_JSP);
        rd.forward(req, resp);

    }



}
