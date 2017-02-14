<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Login Page</title>
<link href="./myside.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
var capnum = 0;

	
var imagesArray = ["images/img1.jpg", "images/img2.jpg", "images/img3.jpg", "images/img4.jpg", "images/img5.jpg", "images/img6.jpg"];
function myFunction(){
     capnum++;
     document.getElementById('display').innerHTML = capnum;
    
     if(capnum==2){
    	 capnum = 0;
    	 var num = Math.floor(Math.random() * 6); // 0...5
    	 window.open(imagesArray[num],"mywin","menubar=0,resizable=0,width=200,height=200")
    	 document.getElementById('one').value =imagesArray[num];
    	}
 }
</script>

</head>
    <body>
        <form method="post" action="/OnlineTask/uploadServlet" enctype="multipart/form-data">
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
		     <td> <img id="img1"src="images/img1.jpg" onClick="myFunction()" ></td>
		     <td> <img id="img2" src="images/img2.jpg" onClick="myFunction()" ></td>
		     <td> <img id="img3" src="images/img3.jpg" onClick="myFunction()" ></td>
		   </tr>
		   <tr>
		     <td> <img id="img4" src="images/img4.jpg" onClick="myFunction()"></td>
		     <td> <img id="img5" src="images/img5.jpg" onClick="myFunction()"></td>
		     <td> <img id="img6" src="images/img6.jpg" onClick="myFunction()"></td>
		   </tr>
		</table>
		
		<div id="display" style="visibility:hidden"><script type="text/javascript"></script></div>
		 
		
	  <input type="text" name="selectedImage" id="one" style="visibility:hidden">
		<input type="submit" value="Save">
		
         </form>
    </body>
</html>