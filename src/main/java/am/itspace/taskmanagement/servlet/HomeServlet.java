package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.manager.UserManager;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.User;
import am.itspace.taskmanagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        try {
            List<Task> allTaskByUserId = taskManager.getAllTaskByUserId(user.getId());
            req.setAttribute("tasks",allTaskByUserId);
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
