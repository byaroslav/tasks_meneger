package ua.artcode.controller;

import ua.artcode.service.ITaskService;
import ua.artcode.service.IUserService;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by Yaroslav on 24.01.2015.
 */
@WebServlet
public class MainController extends HttpServlet {
    ITaskService taskService;
    IUserService userService;

    @Override
    public void init() throws ServletException {
         taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
         userService = (UserServiceImpl) getServletContext().getAttribute("userService");
    }
}
