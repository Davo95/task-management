package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        try {
            taskManager.deleteTask(taskId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getSession().setAttribute("msg","Task was remove");
        resp.sendRedirect("/home");
    }
}
