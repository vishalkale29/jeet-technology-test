import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ConnectionDb;
 
@WebServlet("/LoginServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class LoginServlet extends HttpServlet {
     
  
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	String firstName = request.getParameter("firstName");

		System.out.println(" name  " + firstName);
		String emailid = request.getParameter("emailid");

		String password = request.getParameter("selected");
		System.out.println(" Label Name "+password);
		
		InputStream in=null;
		try{
		URL url = new URL(password);
		 in = new BufferedInputStream(url.openStream());
		}catch(Exception e){
			System.out.println(" Message "+e);
		}

		System.out.println(" user password"+in);
	
		Connection con = null;
		String message = null;
		
		int flag=0;

		try {
			// connects to the database

			con = ConnectionDb.databaseConnectivity();

			if (con != null) {

				System.out.println(" Connection Established");
			}

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userregister where emailid=" + emailid);

			String dbname = rs.getString("EMAILID");
			InputStream dbpassword = rs.getBinaryStream(2);
			
			System.out.println("dbpassword"+dbpassword);
			
			
			System.out.println(" dbnae" + dbname + " " + dbpassword);
            if (dbname.equals(emailid) && dbpassword.equals(in)) {

				System.out.println(" Matched");
				response.sendRedirect("home.jsp");
			}

		} catch (SQLException ex) {
			message = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (con != null) {
				// closes the database connection
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			// sets the message in request scope
			request.setAttribute("Message", message);

			// forwards to the message page
			getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
		
		
		}

		if(in!=null)
		in.close();

	}
   
}
