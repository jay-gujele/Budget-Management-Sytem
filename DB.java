package pettycash;

/*------------------------------------------------------------------------------------------------------
System: Library Management System
 Details: DB.java	(Connection details)
 Team / Programmer Name
 Version:						Date: 				 Review By:
-------------------------------------------------------------------------------------------------------*/
import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
public static Connection getConnection()
{
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
			 con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","jay","jay"); 
					
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
