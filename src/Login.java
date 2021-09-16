import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{
//JFrame jf;
private JPanel contentPane;
private String Fname,Password;
private JLabel error;
private String errorText="Invalid user name or password";
private JLabel lblCaddeyLogin,label;
private JTextField txtUserName;
private JButton btnLogin;//reset
private JPasswordField txtPassword;
// LAunch the application
public static void main(String args[] ) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Login frame=new Login();
				frame.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	});
}

//create frame

public Login()
{
	setTitle("Login");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100,100,500,400);
	contentPane=new JPanel();
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
//jf=new JFrame("Login Frame");
//jf=new JFrame("Password field");
//txtpwd=new JPasswordField();
//lblname=new JLabel("UserName");
//lblpwd=new JLabel("Password");
//lblDisplay=new JLabel();
	JLabel lblUserName=new JLabel("UserName");
	lblUserName.setBounds(100,90,100,20);
	contentPane.add(lblUserName);
	
	txtUserName=new JTextField();
	txtUserName.setBounds(200,90,100,20);
	contentPane.add(txtUserName);
	txtUserName.setColumns(10);
   
	JLabel lblPassword=new JLabel("Password\r\n");
	lblPassword.setBounds(100, 130, 100, 20);
	contentPane.add(lblPassword);
	
	txtPassword=new JPasswordField();
	txtPassword.setBounds(200, 130, 100, 20);
	contentPane.add(txtPassword);
	//txtPassword.setColumns(10);
	
	txtPassword.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btnLogin.doClick();
			
		}
	});
	btnLogin=new JButton("Login");
	btnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Password=new String(txtPassword.getPassword()).toLowerCase();
			Fname=new String(txtUserName.getText().toString()).toLowerCase();
			txtPassword.setText("");
			txtUserName.setText("");
			if(Fname.equals("")||Password.equals(""))
			error.setText(errorText);
				else
			{
				error.setText("");
				if(Fname.equals("SignupFrom"))
				{
					if(Connectivity.varifyLogin(Fname,Password))
					{
					error.setText("");	
	//				OnlineTest ex= new OnlineTest("Name:"+Fname+"Password:"+Password);
		//			ex.setVisible(true);
					
					}
					else
					{
						error.setText(errorText);
					}	
				}
				else
				{
					if(Connectivity.varifyLogin(Fname,Password))
					{
						error.setText("");
						OnlineTest ex= new OnlineTest("Name:"+Fname+"Password:"+Password);
						ex.setVisible(true);	
						
					}
					else
		
						error.setText(errorText);
					
		
					}
				}
			}
		
		});
	btnLogin.setBounds(200, 200, 89, 23);
	contentPane.add(btnLogin);
//	onlineTest ex=new onlineText();
	
	error = new JLabel("");
//	error.setForeground(Color.RED);
	error.setBounds(104, 236, 220, 14);
	contentPane.add(error);
	
	lblCaddeyLogin = new JLabel("Login page");
//	lblCaddeyLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblCaddeyLogin.setBounds(204, 26, 167, 28);
	contentPane.add(lblCaddeyLogin);
	
	label = new JLabel("");
//	label.setIcon(new ImageIcon("E:\\XAMPP\\htdocs\\logo.png"));
//	label.setBounds(10, 11, 167, 91);
	contentPane.add(label);
	
	
}
}
/*public static String getMac()
{
	InetAddress ip;
	String mc="";
	try {
		ip = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
	
		mc= sb.toString();

	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mc; */



//Login=new JButton("Login");
//reset=new JButton("Reset");

//lblname.setBounds(50,50,100,20);
//txtname.setBounds(155,50,100,20);
//lblpwd.setBounds(50, 100, 100, 20);
//txtpwd.setBounds(155, 100, 100, 20);
//Login.setBounds(100, 150, 100, 20);
//Login.setBounds(170, 150, 100, 20);
//Login.addActionListener(this);

//reset.addActionListener(this);

/*jf.add(lblname);
jf.add(txtname);
jf.add(lblpwd);
jf.add(txtpwd);
jf.add(Login);
//jf.add(val);
//jf.add(reset);
jf.add(lblDisplay);

jf.setSize(400,400);
jf.setLayout(null);
jf.setVisible(true);
jf.setDefaultCloseOperation(1);
}


@Override
public void actionPerformed(ActionEvent arg0) {
/*if(lblname.getText().trim().isEmpty() && lblpwd.getText().trim().isEmpty() )
	{
		lblname.setText("Username is Empty");
		lblpwd.setText("Password is Empty");
	}
	else if(lblname.getText().trim().isEmpty())
	{
		lblname.setText("Username is Empty");
	}
	else if(lblpwd.getText().trim().isEmpty())
	{
		lblpwd.setText("Password is Empty");
	} */
// TODO Auto-generated method stub
//String s=arg0.getActionCommand();
/*String nm=txtname.getText();
//String ps="Gls@123";*/
//String Fname=txtname.getText();
/*String Password=txtpwd.getText();
if(Fname.isEmpty() && Password.isEmpty())
{
JOptionPane.showMessageDialog(Login,this, "Plese enter information",0);
}
else if(Fname.length()==0 )
{
JOptionPane.showMessageDialog(Login,this,"enter username",0);
}
else if(Password.length()==0 )
{
JOptionPane.showMessageDialog(Login,this,"enter password",0);
}
if(Fname.length()>1 && Password.length()>1)
{
if(s.equals("Login"))
		{
		lblDisplay.setText("Name:"+Fname+"Password:"+Password);
		//Display dip=new Display("Name:"+nm+"Password:"+ps);
		OnlineTest ex= new OnlineTest("Name:"+Fname+"Password:"+Password);
		}
	}
}

public static void main(String args[])
{
Login lg=new Login();
}
} */
