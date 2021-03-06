package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.TaskStatus;
import am.itspace.taskmanagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(urlPatterns = "/addTask")
public class TaskServlet extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private TaskManager taskManager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        String deadline = req.getParameter("deadline");

        try {
            taskManager.addTask(Task.builder()
                    .name(name)
                    .description(description)
                    .deadline(sdf.parse(deadline))
                    .status(TaskStatus.valueOf(status))
                    .userId(user)
                    .build());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("smg", "Task was added");
        resp.sendRedirect("/home");
    }
}
