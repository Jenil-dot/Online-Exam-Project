import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
public class SignupFrom extends JFrame  {
//	private Connection conn =null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; //declare variable
	private JTextField txtFname,txtLname,txtMnum,txtEmail,txtDisplay;
	private JButton btnSubmit;
	private JTextArea txtAddress;
	private JPasswordField txtPassword;
	protected java.lang.String Spassword;
	
	// database URL
	static final String DB_URL = "jdbc:mysql://localhost/demo5";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "jenildesai";
	protected static final String String = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException,SQLException // main method
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() //define run method
			{
				try  //try block
				{
					//create NewUser frame object
					SignupFrom frame = new SignupFrom();
                                        //set NewUser frame visible
					frame.setVisible(true);
				} 
				catch (Exception se) //catch block
				{
					se.printStackTrace();
				}
			}
		});
		//Login lg=new Login();
	}
	/**
	 * Create the frame.
	 */
	public SignupFrom() //create constructor
	{	
		//set title
		setTitle("New User Login");
		//set close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set bounds of frame
		setBounds(100, 100, 450, 800);
		//create object of JPanel
		contentPane = new JPanel();
                //set contentPane border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	set ContentPane with new object
		setContentPane(contentPane);
	//	set contentPane layout is null
		contentPane.setLayout(null);
		
                // create text field for user
		txtFname = new JTextField();
		//set bounds for text fields
		txtFname.setBounds(188, 51, 99, 20);
		//in contentPane add text field
		contentPane.add(txtFname);
		//set column for text field
		txtFname.setColumns(10);

		txtLname = new JTextField();
		//set bounds for text fields
		txtLname.setBounds(188, 105, 130, 25);
		//in contentPane add text field
		contentPane.add(txtLname);
		//set column for text field
		txtLname.setColumns(10);


		txtMnum = new JTextField();
		//set bounds for text fields
		txtMnum.setBounds(188, 155, 130, 25);
		//in contentPane add text field
		contentPane.add(txtMnum);
		//set column for text field
		txtLname.setColumns(10);

		txtAddress = new JTextArea();
		//set bounds for text fields
		txtAddress.setBounds(188,210,130,70);
		//in contentPane add text field
		contentPane.add(txtAddress);
		//set column for text field
		txtAddress.setColumns(10);

		txtEmail = new JTextField();
		//set bounds for text fields
		txtEmail.setBounds(188, 310, 130, 25);
		//in contentPane add text field
		contentPane.add(txtEmail);
		//set column for text field
		txtEmail.setColumns(10);
		
		//lable the text field
		//lable the text field
		JLabel lblFname = new JLabel("First Name");
		//set bounds for label
		lblFname.setBounds(70, 54, 86, 14);
		//add into contentPane
		contentPane.add(lblFname);
		JLabel lblLname = new JLabel("Last Name");
		//set bounds for label
		lblLname.setBounds(70, 109, 86, 14);
		//add into contentPane
		contentPane.add(lblLname);
		JLabel lblMnum = new JLabel("Mobile number");
		//set bounds for label
		lblMnum.setBounds(70, 164, 86, 14);
		//add into contentPane
		contentPane.add(lblMnum);
		JLabel lblAddress = new JLabel("Address");
		//set bounds for label
		lblAddress.setBounds(70, 219, 86, 14);
		//add into contentPane
		contentPane.add(lblAddress);
		JLabel lblEmail = new JLabel("Email");
		//set bounds for label
		lblEmail.setBounds(70, 310, 86, 14);
		//add into contentPane
		contentPane.add(lblEmail);
		JLabel lblPassword = new JLabel("Password");
		//set bounds for label
		lblPassword.setBounds(70, 375, 86, 14);
		//add into contentPane
		contentPane.add(lblPassword); 
		
		
                //c.reate button signu
		btnSubmit = new JButton("Signup");
		//add event handler on SignUp button
		btnSubmit.addActionListener(new ActionListener()
                {
		                public void actionPerformed(ActionEvent e) 
                                {				
                                
		                //	btnSubmit.doClick();
		//    				Login lg=new Login();             
				//Create wrapper object and define it null
				Wrapper conn = null;
				try  //try block
                                {
                                //declare variables
					String Fname = "";
					String Lname = "";
					String Mnum = "";
					String Address = "";
					String Email = "";
					String Password = "";
					
					//get values using getText() method'
				   Fname = txtFname.getText().trim();
				   Lname = txtLname.getText().trim();
					Mnum = txtMnum.getText().trim();
				 Address = txtAddress.getText().trim();
				   Email = txtEmail.getText().trim();
				 Password = txtPassword.getText().trim();
				
                                // check condition it field equals to blank throw error message
				if (Fname.equals("") || Lname.equals("") || Mnum.equals("") || Address.equals("") || Email.equals("") || Password.equals(""))
				{
					JOptionPane.showMessageDialog(null," name or password or Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
				else  //else insert query is run properly
                                {
					String IQuery = "INSERT INTO signupacc (`Fname`,`Lname`,`Mnum`,`Address`,`Email`,`Password`) VALUES('"+Fname+"', '"+Lname+"','"+Mnum+"','"+Address+"','"+Email+"','"+Password+"')";
					System.out.println(IQuery);//print on console
					System.out.println("Connecting to a selected database...");
				//STEP 3: Open a connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5","root","jenildesai");
					System.out.println("Connected database successfully...");
				((Connection)conn).createStatement().execute(IQuery);//select the rows
					// define SMessage variable
					String SMessage = "Record added for "+Fname+Lname+Mnum+Address+Email;
					
                                       // create dialog ox which is print message
	                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
					//close connection
					((java.sql.Connection)conn).close();
				}				
			}
			catch (Exception se) 
			{
				//handle errors for JDBC
				se.printStackTrace();
			}
		/*	}
			catch (Exception a) //catch block
			{*/
				//se.printStackTrace();
			
           }
		
	});
		//set bound for SignUp button
		btnSubmit.setBounds(131, 450, 89, 23);
		//add button into contentPane
		contentPane.add(btnSubmit);
		
		//create text field for password
		txtPassword = new JPasswordField();
		//set bound for password field
		txtPassword.setBounds(188, 370, 130, 25);
		//add text field on contentPane
		contentPane.add(txtPassword); 
		//set column for password text field
		//txtPassword.setColumns(10);
		txtPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSubmit.doClick();
				Login lg=new Login();
				lg.setVisible(true);
			}
		});
		}
}

/* import java.awt.FlowLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class SignupFrom  extends JFrame
{
	//private Connection connect =null;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	//private JLabel lblFname,lblLname,lblMnum,lblAddress,lblEmail,lblPassword,lblDisplay;
	private	JTextField txtFname,txtLname,txtMnum,txtEmail,txtDisplay;
	private JButton btnSubmit;//,btnReset; 
	private	JTextArea txtAddress;
	private JPasswordField txtPassword;
	protected java.lang.String Spassword;//SMessage;
	
	static final String DB_URL = "jdbc:mysql://localhost/demo5/signupacc";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "jenildesai";
	protected static final String String = null;
	
	public static void main(String[] args) throws SQLException,ClassNotFoundException // main method
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() //define run method
			{
				try  //try block
				{
					//create NewUser frame object
					SignupFrom frame = new SignupFrom();
                                        //set NewUser frame visible
					frame.setVisible(true);
				} 
				catch (Exception e) //catch block
				{
					e.printStackTrace();
				}
			}
		});
	}
	public SignupFrom()
	{
		setTitle("New User");
		//set close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set bounds of frame
		setBounds(100, 100, 450, 1000);
		contentPane = new JPanel();
        //set contentPane border
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	set ContentPane with new object
setContentPane(contentPane);
contentPane.setLayout(null);

// create text field for user
txtFname = new JTextField();
//set bounds for text fields
txtFname.setBounds(188, 51, 130, 25);
//in contentPane add text field
contentPane.add(txtFname);
//set column for text field
txtFname.setColumns(10);

txtLname = new JTextField();
//set bounds for text fields
txtLname.setBounds(188, 105, 130, 25);
//in contentPane add text field
contentPane.add(txtLname);
//set column for text field
txtLname.setColumns(10);


txtMnum = new JTextField();
//set bounds for text fields
txtMnum.setBounds(188, 155, 130, 25);
//in contentPane add text field
contentPane.add(txtMnum);
//set column for text field
txtLname.setColumns(10);

txtAddress = new JTextArea();
//set bounds for text fields
txtAddress.setBounds(188,210,130,70);
//in contentPane add text field
contentPane.add(txtAddress);
//set column for text field
txtAddress.setColumns(10);

txtEmail = new JTextField();
//set bounds for text fields
txtEmail.setBounds(188, 310, 130, 25);
//in contentPane add text field
contentPane.add(txtEmail);
//set column for text field
txtEmail.setColumns(10);

//txtDisplay = new JTextField();
//set bounds for text fields
//txtDisplay.setBounds(188, 550, 130, 50);
//in contentPane add text field
//contentPane.add(txtDisplay);
//set column for text field
//txtDisplay.setColumns(10);

//lable the text field
JLabel lblFname = new JLabel("First Name");
//set bounds for label
lblFname.setBounds(70, 54, 86, 14);
//add into contentPane
contentPane.add(lblFname);
JLabel lblLname = new JLabel("Last Name");
//set bounds for label
lblLname.setBounds(70, 109, 86, 14);
//add into contentPane
contentPane.add(lblLname);
JLabel lblMnum = new JLabel("Mobile number");
//set bounds for label
lblMnum.setBounds(70, 164, 86, 14);
//add into contentPane
contentPane.add(lblMnum);
JLabel lblAddress = new JLabel("Address");
//set bounds for label
lblAddress.setBounds(70, 219, 86, 14);
//add into contentPane
contentPane.add(lblAddress);
JLabel lblEmail = new JLabel("Email");
//set bounds for label
lblEmail.setBounds(70, 310, 86, 14);
//add into contentPane
contentPane.add(lblEmail);
JLabel lblPassword = new JLabel("Password");
//set bounds for label
lblPassword.setBounds(70, 375, 86, 14);
//add into contentPane
contentPane.add(lblPassword);

//JLabel lblDisplay =new JLabel();
//lblDisplay.setBounds(100,550,86,14);
//contentPane.add(lblDisplay);

btnSubmit = new JButton("Submit");
//add event handler on SignUp button
btnSubmit.addActionListener(new ActionListener() 
        {
                public void actionPerformed(ActionEvent e) 
                        {
                	
                        
                        
		//Create wrapper object and define it null
		Wrapper conn = null;
		try  //try block
                        {
                        //declare variables
		String Fname = "";
		String Lname = "";
		String Mnum = "";
		String Address = "";
		String Email = "";
		String Password = "";
		
		//get values using getText() method'
	   Fname = txtFname.getText().trim();
	   Lname = txtLname.getText().trim();
		Mnum = txtMnum.getText().trim();
	 Address = txtAddress.getText().trim();
	   Email = txtEmail.getText().trim();
	 Password = txtPassword.getText().trim();
	// Display=txtDisplay.getText().trim();
	 
	 if (Fname.equals("")|| Lname.equals("")|| Mnum.equals("")|| Address.equals("")|| Email.equals("")|| Password.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
		}
	//	if(e.equals("btnSubmit"))
		//{
		//txtDisplay.getText("Name:"+Fname+"lastname:"+Lname+"Mnumber:"+Mnum+"Address:"+Address+"Email:"+Email+"password:"+Password);
		//Display dip=new Display("Name:"+Fname+"Password:"+Password);
	//		Login lg= new Login("Name:"+Fname+"password:"+Password);
	//	Login lg= new Login();
		//}
	 else  //else insert query is run properly
     {
		 String  IQuery= "INSERT INTO signupacc(`Fname`,`Lname`,`Mnum`,`Address`,`Email`,`Password`) VALUES('"+Fname+"', '"+Lname+"','"+Mnum+"','"+Address+"','"+Email+"','"+Password+"')";
		 System.out.println(IQuery);//print on console
		 System.out.println("Connecting to a selected database...");
		 //STEP 3: Open a connection
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5","root","jenidesai");
	System.out.println("Connected database successfully...");
	((Connection)conn).createStatement().execute(IQuery);//select the rows
	// define SMessage variable
	String SMessage = "Record added for "+Fname+Lname+Mnum+Address+Email;
	
                       // create dialog ox which is print message
        JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
	//close connection
      
	((java.sql.Connection)conn).close();
     }
  }
		catch (Exception a) //catch block
		{
			a.printStackTrace();
		}
       }
});
btnSubmit.setBounds(131, 450, 89, 23);
//add button into contentPane
contentPane.add(btnSubmit);
txtPassword = new JPasswordField();
//set bound for password field
txtPassword.setBounds(188, 370, 130, 25);
//add text field on contentPane
contentPane.add(txtPassword); 
//set column for password text field
txtPassword.setColumns(10);				

}				
	
} */




/*	new JFrame("Register Form");
	lblFname=new JLabel("First Name");
	lblLname=new JLabel("Last Name");
	lblMnum=new JLabel("Mobile Number");
	lblAddress=new JLabel("Address");
	lblEmail=new JLabel("Email");
	lblPassword=new JLabel("Password");
	lblDisplay=new JLabel();
	txtFname=new JTextField(20);
	txtLname=new JTextField(20);
	txtMnum=new JTextField(20);
	txtAddress=new JTextArea(5,5);
	txtEmail=new JTextField(20);
	txtPassword=new JTextField(20);
	btnSubmit=new JButton("Submit");
	btnReset=new JButton("Reset");
	lblFname.setBounds(50,50,100,20);
	txtFname.setBounds(155,50,200,20);
	//txtFname.setBounds(155,50,200,20);
	txtFname.setBounds(155,50,200,20);
	lblLname.setBounds(50,100,100,20);
	txtLname.setBounds(155,100,200,20);
	lblMnum.setBounds(50,150,100,20);
	txtMnum.setBounds(155,150,200,20);
	lblAddress.setBounds(50,200,100,20);
	txtAddress.setBounds(155,200,200,70);
	lblEmail.setBounds(50,300,100,20);
	txtEmail.setBounds(155,300,200,20);
	lblPassword.setBounds(50,350,100,20);
	txtPassword.setBounds(155,350,200,20);
	btnSubmit.setBounds(100,400,100,20);
	btnReset.setBounds(250,400,100,20);
	btnSubmit.addActionListener(this); */
	
	/*jf.add(lblFname);
	jf.add(txtFname);
	jf.add(lblLname);
	jf.add(txtLname);
	jf.add(lblMnum);
	jf.add(txtMnum);
	jf.add(lblAddress);
	jf.add(txtAddress);
	jf.add(lblEmail);
	jf.add(txtEmail);
	jf.add(lblPassword);
	jf.add(txtPassword);
	jf.add(btnSubmit);
	jf.add(btnReset);
	jf.add(lblDisplay); */
//	jf.setSize(800,800);
//	jf.setLayout(null);
//	jf.setVisible(true);
//	jf.setDefaultCloseOperation(1);
//	} 
/*	public void actionPerformed(ActionEvent arg0)
	{
		String s=arg0.getActionCommand();
		//String nm=txtname.getText();
	//	String ps="Gls@123";
		String fn=txtFname.getText();
		String ln=txtLname.getText();
		String mn=txtMnum.getText();
		String ad=txtAddress.getText();
		String em=txtEmail.getText();
		String ps=txtPassword.getText();
		if(fn.isEmpty() && ln.isEmpty() && mn.isEmpty() && ad.isEmpty() && em.isEmpty() && ps.isEmpty())
		{
		JOptionPane.showMessageDialog(btnSubmit,this, "Plese enter information",0);
		}
		else if(fn.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter username",0);
		}
		else if(ln.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter password",0);
		}
		else if(mn.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter your mobile numner",0);
		}
		else if(ad.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter Your Address",0);
		}
		else if(em.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter YOur email",0);
		}
		else if(ps.length()==0 )
		{
		JOptionPane.showMessageDialog(btnSubmit,this,"enter Yore password",0);
		}
		if(fn.length()>1 && ln.length()>1 && mn.length()>1 && ad.length()>1 && em.length()>1 && ps.length()>1)
		{
		if(s.equals("Submit"))
				{
				lblDisplay.setText("Name:"+fn+"lastname:"+ln+"Mnumber:"+mn+"Address:"+ad+"Email:"+em+"password:"+ps);
				//Display dip=new Display("Name:"+nm+"Password:"+ps);
		//	Login lg= new Login("Name:"+fn+"password:"+ps);
				Login lg= new Login();
				}
			}
		} 
//	public static void main(String args[])
	//{
		//SignupFrom sf=new SignupFrom();
	
	//	Login lg=new Login();
	//}
} 
*/

