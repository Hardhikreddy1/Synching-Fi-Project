package programs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private boolean isValidUser(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Email = request.getParameter("Email");
        String password = request.getParameter("password");

        if ("hardhik@gmail.com".equals(Email) && "12345".equals(password)  ) {
            response.getWriter().write("Login Successful Welcome To Page " + Email);
            response.sendRedirect("Dashboard.html");
        } else {
            response.getWriter().write("Invalid username or password.");
        }
    }
}
