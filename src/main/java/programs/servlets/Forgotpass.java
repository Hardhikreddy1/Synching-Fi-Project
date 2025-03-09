package programs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forgotpass")
public class Forgotpass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String Token = request.getParameter("Token");
        String Newpassword = request.getParameter("newpassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Trim inputs to remove leading or trailing spaces
        Newpassword = Newpassword != null ? Newpassword.trim() : "";
        confirmPassword = confirmPassword != null ? confirmPassword.trim() : "";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

  
        if (Newpassword.isEmpty() || confirmPassword.isEmpty()) {
            out.println("<h3>Please fill in both password fields.</h3>");
            out.println("<a href='reset.html'>Click Here To Reset The Password</a>");
            return;
        }

  
        if (!Newpassword.equals(confirmPassword)) {
            out.println("<h3>Passwords match! You can now proceed to update your password.</h3>");
            out.println("<a href='File.html'>Click Here To Reset The Password</a>");
            return;
        }
        out.println("<h3>Passwords match! You can now proceed to update your password.</h3>");
        
       
        if ("validToken123".equals(Token)) {
            out.println("<h3>Password updated successfully!</h3>");
            out.println("<p><a href='login.html'>Click here to log in</a></p>");
        } else {
            out.println("<h3>Invalid token. Please request a new password reset link.</h3>");
            out.println("<a href='File.html'>Click Here To Reset The Password</a>");
        }
    }
}

