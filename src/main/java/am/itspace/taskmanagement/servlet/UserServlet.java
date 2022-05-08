package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.UserManager;
import am.itspace.taskmanagement.model.User;
import am.itspace.taskmanagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addUser")
public class UserServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String userType = req.getParameter("user_type");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");
        if (!password.equals(rePassword)) {
            req.getSession().setAttribute("msg", "password are not match");
            resp.sendRedirect("/");
        }else {
            userManager.addUser(User.builder()
                    .name(name)
                    .surname(surname)
                    .userType(UserType.valueOf(userType))
                    .email(email)
                    .password(password)
                    .build());
            req.getSession().setAttribute("msg", "User was register successfully");
            resp.sendRedirect("/admin");
        }
    }
}

