package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.TaskStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        Task task = taskManager.getTaskById(taskId);
        req.setAttribute("task", task);
        req.getRequestDispatcher("/WEB-INF/updateTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        Task taskById = taskManager.getTaskById(taskId);
        if (taskById != null) {

            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String status = req.getParameter("status");

            Task task = Task.builder()
                    .id(taskId)
                    .name(name)
                    .description(description)
                    .status(TaskStatus.valueOf(status))
                    .build();
            taskManager.addTask(task);
            req.getSession().setAttribute("smg", "Task was updated");
            resp.sendRedirect("/home");
        }
    }
}
