import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListCookies")
public class ListCookies extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>List Cookies</title></head><body>");
        out.println("<h2>List of Cookies</h2>");

        // Check if cookies exist
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }
        out.println("</body></html>");
        out.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
