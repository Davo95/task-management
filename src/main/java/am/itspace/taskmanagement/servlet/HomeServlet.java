package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.manager.UserManager;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = taskManager.getTask();
        List<User> users = userManager.getUser();
        req.setAttribute("tasks", tasks);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
