import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class Servlet2 extends HttpServlet { 
 public void doGet(HttpServletRequest request, 
 HttpServletResponse response){ 
 try{ 
 response.setContentType("text/html"); 
 PrintWriter pwriter = response.getWriter(); 
 
 //Reading cookies 
 Cookie c[]=request.getCookies(); 
 //Displaying User name and User Password value from cookie 
 
for(int i=0;i<c.length;i++){ 
pwriter.print("<br>"+c[i].getName()+": "+c[i].getValue()); 
} 
 pwriter.close(); 
 }catch(Exception exp){ 
 System.out.println(exp); 
 } 
 } 
}