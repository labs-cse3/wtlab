import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class Servlet_ageverify extends HttpServlet 
{ 
 public void service(HttpServletRequest req, HttpServletResponse res) throws 
IOException,ServletException 
 { 
 res.setContentType("text/html"); 
 PrintWriter pw = res.getWriter(); 
 String name = req.getParameter("name"); 
 int age = Integer.parseInt(req.getParameter("age")); 
 if (age>=18) 
 { 
 pw.println("Welcome "+name+" to this site"); 
 } 
 else 
 pw.println("Hello "+name+",you are not authorized to visit the site"); 

 //close the stream 
 pw.close(); 
 } 
}	