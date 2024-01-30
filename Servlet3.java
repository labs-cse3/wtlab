import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class Servlet1 extends HttpServlet 
{ 
 public void doGet(HttpServletRequest request, HttpServletResponse response) { 
 try{ 
 response.setContentType("text/html"); 
 PrintWriter pwriter = response.getWriter(); 
 String uname = request.getParameter("Name"); 
 String upassword = request.getParameter("Password"); 
 pwriter.print("Cookies Set:<br>Hello "+uname); 
 pwriter.print("<br>Your Password is: "+upassword); 
 //Creating two cookies 
 Cookie c1=new Cookie("Name",uname); 
 Cookie c2=new Cookie("Password",upassword); 
 //Adding the cookies to response header 
 response.addCookie(c1); 
 response.addCookie(c2); 
 pwriter.print("<a href='Servlet2'>LIST COOKIES</a>"); 
 pwriter.close(); 
 }catch(Exception exp){ 
 System.out.println(exp); 
 } 
 } 
}