import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>List Cookies</title></head><body>");
        out.println("<h2>Cookie set</h2>");
        String UName = request.getParameter("name");
        String Upass = request.getParameter("password");
        out.println("<p>New cookie added: Name = " + UName + " Password =" + Upass + "</p><br>");
        out.println("<h2> List cookies </h2>");
        out.println("<form action='ListCookies' method='get'>"
        		+ "        <button type='submit'>List Cookies</button>"
        		+ "    </form>");
        out.println("</body></html>");
        String encodedValue = URLEncoder.encode(UName, StandardCharsets.UTF_8.toString());
        Cookie c1 = new Cookie("Name", encodedValue);
        Cookie c2 = new Cookie("password", Upass);
        response.addCookie(c1);
        response.addCookie(c2);
        out.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
