package am.itspace.taskmanagement.servlet;

import am.itspace.taskmanagement.model.Task;
import am.itspace.userbook.manager.BookManager;
import am.itspace.userbook.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateBook")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UpdatetAaskServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "D:\\homework\\UserBook\\upload/";
    private TaskServlet taskServlet = new TaskServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        Task task = taskServlet.getTaskById(bookId);
        req.setAttribute("task", task);
        req.getRequestDispatcher("/WEB-INF/updateBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        Book bookById = taskServlet.getBookById(bookId);
        if (bookById != null){

            Part filePart = req.getPart("picture");
            String fileName = filePart.getSubmittedFileName();
            String picUrl = System.currentTimeMillis() + "_" + fileName;
            filePart.write(UPLOAD_DIR + picUrl);

            String title = req.getParameter("title");
            String authorName = req.getParameter("authorName");
            double price = Double.parseDouble(req.getParameter("price"));

            Book book = Book.builder()
                    .id(bookId)
                    .title(title)
                    .authorName(authorName)
                    .price(price)
                    .picUrl(picUrl)
                    .build();
            taskServlet.addBook(book);
            req.getSession().setAttribute("smg", "Book was updated");
            resp.sendRedirect("/home");
        }
    }
}
