<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Login Page</title>
<link href="./myside.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function myFunction(img){
      document.getElementById('one').value =img.src;
 }
</script>

</head>
    <body>
        <form method="post" action="/OnlineTask/LoginServlet" enctype="multipart/form-data">
        
         <input type="text" name="selected" id="one">
        
        
        
             <table>
                 <tr>
                    <td>
                     <lable>USER-NAME:</lable>
                     <input type="text" name="firstName"></td>
                 </tr>
                 
                 <tr>
                    <td>
                     <lable>EMAIL-ID:</lable>
                     <input type="text" name="emailid"></td>
                 </tr>
                 
                 <tr>
                    <td>
                     <lable>PASSWORD:</lable></td>
                 </tr>             
             </table>
        
		<table>
		   <tr>
		     <td> <img id="img1"src="images/img1.jpg" onClick="myFunction(this)" ></td>
		     <td> <img id="img2" src="images/img2.jpg" onClick="myFunction(this)" ></td>
		     <td> <img id="img3" src="images/img3.jpg" onClick="myFunction(this)" ></td>
		   </tr>
		   <tr>
		     <td> <img id="img4" src="images/img4.jpg" onClick="myFunction(this)"></td>
		     <td> <img id="img5" src="images/img5.jpg" onClick="myFunction(this)"></td>
		     <td> <img id="img6" src="images/img6.jpg" onClick="myFunction(this)"></td>
		   </tr>
		</table>
		
	 
	  
	  
	  <input type="submit" value="Login">
		
         </form>
    </body>
</html>