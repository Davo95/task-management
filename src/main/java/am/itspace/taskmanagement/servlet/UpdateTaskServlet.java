package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.TaskStatus;
import am.itspace.taskmanagement.model.User;
import am.itspace.taskmanagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String status = req.getParameter("status");
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        taskManager.updateTask(taskId, status);

        if (user.getUserType() == UserType.ADMIN) {
            resp.sendRedirect("/admin");
        } else {
            resp.sendRedirect("/home");
        }
    }
}
