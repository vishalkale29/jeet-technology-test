import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ConnectionDb;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
  
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String firstName = request.getParameter("firstName");
        
        System.out.println(" name  "+firstName );
        String emailid = request.getParameter("emailid");
        
        String labelName = request.getParameter("selectedImage");
        System.out.println(" selectedImage Name "+labelName);
        
        
        URL url = new URL("http://localhost:8081/OnlineTask/"+labelName);
        InputStream in = new BufferedInputStream(url.openStream());
       
      
        Connection conn=null;
        String message=null;
        
        try {
            // connects to the database
           
            conn =ConnectionDb.databaseConnectivity();
           
            if(conn!=null){
            	
            	System.out.println(" Connection Established");
            }
            
          // constructs SQL statement
            String sql = "INSERT INTO userregister (username, emailid, password) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, emailid);
             
            if (in != null) {
                // fetches input stream of the upload file for the blob column
            	System.out.println(" data "+in);
                statement.setBlob(3, in);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        
        
        
        in.close();
   
}
}