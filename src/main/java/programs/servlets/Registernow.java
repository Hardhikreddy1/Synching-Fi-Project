package programs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registernow")
public class Registernow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String gender = request.getParameter("gender");

    
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || 
            email == null || email.isEmpty() || password == null || password.isEmpty() || 
            confirmPassword == null || confirmPassword.isEmpty() || gender == null || gender.isEmpty()) {
            out.println("<html><body>");
            out.println("<h3>Registration Successful</h3>");
            out.println("<p><a href='File.html'>Go Back</a></p>");
            out.println("</body></html>");
            return;
        }

    
        if (!password.equals(confirmPassword)) {
            out.println("<html><body>");
            out.println("<h3>Passwords do not match!</h3>");
            out.println("<p>Please re-enter your passwords.</p>");
            out.println("<p><a href='register.html'>Go Back</a></p>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<p><strong>First Name:</strong> " + escapeHTML(firstName) + "</p>");
        out.println("<p><strong>Last Name:</strong> " + escapeHTML(lastName) + "</p>");
        out.println("<p><strong>Email:</strong> " + escapeHTML(email) + "</p>");
        out.println("<p><strong>Gender:</strong> " + escapeHTML(gender) + "</p>");
        out.println("<p><strong>Password:</strong> " + escapeHTML(password) + "</p>");
        out.println("<p>Proceed to <a href='File.html'>Login</a></p>");
        out.println("</body></html>");
    }

 
    private String escapeHTML(String input) {
        if (input == null) return "";
        return input.replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;")
                    .replaceAll("'", "&#x27;");
    }
}
