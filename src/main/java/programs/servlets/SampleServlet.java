package programs.servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        
        String qualification = request.getParameter("qualification");
        String passoutYear = request.getParameter("passoutYear");
        String percentage = request.getParameter("percentage");
        
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String siblings = request.getParameter("siblings");

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       
        out.println("<html><body>");
        out.println("<h2>Form Data Submitted</h2>");
      
        if (city != null && state != null && country != null) {
            out.println("<h3>Address:</h3>");
            out.println("City: " + city + "<br>");
            out.println("State: " + state + "<br>");
            out.println("Country: " + country + "<br>");
        }

        
        if (qualification != null && passoutYear != null && percentage != null) {
            out.println("<h3>Education:</h3>");
            out.println("Highest Qualification: " + qualification + "<br>");
            out.println("Passout Year: " + passoutYear + "<br>");
            out.println("Percentage: " + percentage + "<br>");
        }

       
        if (fatherName != null && motherName != null && siblings != null) {
            out.println("<h3>Family Details:</h3>");
            out.println("Father's Name: " + fatherName + "<br>");
            out.println("Mother's Name: " + motherName + "<br>");
            out.println("Number of Siblings: " + siblings + "<br>");
        }

        
        out.println("<p>Proceed to <a href='Dashboard.html'>Go Back</a></p>");
        out.println("</body></html>");
    }
}
