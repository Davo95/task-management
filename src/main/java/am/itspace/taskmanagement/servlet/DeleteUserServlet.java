package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.TaskManager;
import am.itspace.taskmanagement.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        try {
            userManager.deleteUser(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getSession().setAttribute("msg","User was remove");
        resp.sendRedirect("/admin");
    }
}
