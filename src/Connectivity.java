//import java.sql.SQLException
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.JOptionPane;
//import java.lang.CLass.forName;

public class Connectivity {
	// JDBC driver name and database URL
				static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				static final String DB_URL = "jdbc:mysql://localhost:3306/demo5";
				//  Database credentials
			    static final String USER = "root";
			    static final String PASS = "jenildesai";
			   public static Connection DBConnection()
			    {
				   Connection conn=null;
				   try //try block
			    	{
			    		//STEP 2: Register JDBC driver
			    		Class.forName("com.mysql.jdbc.Driver");
			    	//	Class.forName(JDBC_DRIVER);
			    		//STEP 3: Open a connection
			    		System.out.println("Connecting to a selected database...");
			    	conn = DriverManager.getConnection(DB_URL,USER,PASS);
			    Statement stmt=conn.createStatement();
			    	String IQuery=null;
			    	  IQuery="SELECT * FROM demo5.signupacc";
			    ResultSet  rs=stmt.executeQuery(IQuery);
			     while(rs.next()) 
			    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
		//	    	conn.close();
			    
			    System.out.println("Connected database successfully...");
			    }
		                        //print on console
			    	    	
			    	
			
			    	catch(Exception e) //catch block
			    	{
			    		//Handle errors for Class.forName
			    		e.printStackTrace();
			    		 //throw new RuntimeException(e);
			    	}
			   
			    	
			    	System.out.println("Goodbye!"); //print on console
		   	return conn;
			    
			    	//end mai
			    	 }
		/*	   public static void add(String Fname,String Lname,int Mnum,String Address,String Email,String Password)
				{
					Connection conn=DBConnection();
					try {
						Statement statement = conn.createStatement();
						statement.executeUpdate("INSERT INTO signupacc VALUES ('"+Fname+"','"+Lname+"','"+Mnum+"','"+Address+"',+'"+Email+"','"+Password+"');");
						JOptionPane.showMessageDialog(null, "People added to database");
						conn.close();
					} catch (SQLException se) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, se.getMessage());
						se.printStackTrace();
					}
				} */
			   public static boolean varifyLogin(String Fname,String Password)
				{
					boolean login=false;
					Connection conn=DBConnection();
					try {
						Statement statement = conn.createStatement();
						ResultSet rs = statement.executeQuery("Select * from signupacc WHERE Fname = '"+Fname+"' and Password = '"+Password+"'");
						if (!rs.next()) 
							login=false;
						else
							login=true;
					        
						conn.close();
					} catch (SQLException se) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, se.getMessage());
				//		 throw new RuntimeException(se);
						se.printStackTrace();
					}
					return login;
				}
			 
			   public static void main(String args[])
			   {
			
				   SignupFrom frame=new SignupFrom();
				   frame.setVisible(true);  
			   }

}

			    
