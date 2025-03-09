package programs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        newPassword = newPassword != null ? newPassword.trim() : "";
        confirmPassword = confirmPassword != null ? confirmPassword.trim() : "";

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            out.println("<html><body>");
            out.println("<h3>Password reset sucessfully</h3>");
            out.println("<p><a href='File.html'>Go back to Login page</a></p>");
            out.println("</body></html>");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            out.println("<html><body>");
            out.println("<h3>Password reset sucessfully</h3>");
            out.println("<p><a href='File.html'>Go back to Login page</a></p>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h3>Password reset successful!</h3>");
        out.println("<p><a href='File.html'>Go to Login</a></p>");
        out.println("</body></html>");
    }
}
