package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.manager.UserManager;
import am.itspace.taskmanagement.model.User;
import am.itspace.taskmanagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = userManager.getUserByEmailAndPassword(email, password);
        if (user == null) {
            req.getSession().setAttribute("msg", "Wrong email or password");
            resp.sendRedirect("/");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if (user.getUserType() == UserType.ADMIN){
                resp.sendRedirect("/admin");
            }else {
                resp.sendRedirect("/home");

            }
        }
    }
}
