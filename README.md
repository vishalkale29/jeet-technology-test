Step for Project run
firstly import your project into workspace
Create table in your database with following this query-- 
CREATE TABLE  "USERREGISTER" 
   (	"USERNAME" VARCHAR2(20), 
	"EMAILID" VARCHAR2(40), 
	"PASSWORD" BLOB, 
	 PRIMARY KEY ("EMAILID") ENABLE
  Se driver connection in control pannel
  Run index.jsp for registration
 change username & pawword in connectiondb class for connect to database
