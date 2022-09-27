package login;

import java.awt.EventQueue;
import login.login_query;
import login.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
import login.usermain;


public class lgn extends JFrame{

	public JFrame lgn;
	private static JTextField usrname;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lgn window = new lgn();
					window.lgn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lgn() {
		initialize();
	}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lgn = new JFrame();
		lgn.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		lgn.setBounds(100, 100, 499, 240);
		lgn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lgn.getContentPane().setLayout(null);
		
		usrname = new JTextField();
		usrname.setFont(new Font("Verdana", Font.PLAIN, 14));
		usrname.setBounds(145, 11, 158, 20);
		lgn.getContentPane().add(usrname);
		usrname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 14, 86, 14);
		lgn.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(49, 45, 86, 14);
		lgn.getContentPane().add(lblNewLabel_1);
		
		JRadioButton one = new JRadioButton("User Login");
		one.setFont(new Font("Verdana", Font.PLAIN, 14));
		one.setBounds(59, 66, 115, 23);
		lgn.getContentPane().add(one);
		
		JRadioButton two = new JRadioButton("Admin Login");
		two.setFont(new Font("Verdana", Font.PLAIN, 14));
		two.setBounds(185, 67, 115, 23);
		lgn.getContentPane().add(two);
		
		JRadioButton three = new JRadioButton("Manager Login");
		three.setFont(new Font("Verdana", Font.PLAIN, 14));
		three.setBounds(302, 67, 135, 23);
		lgn.getContentPane().add(three);
		ButtonGroup grup = new ButtonGroup();
		grup.add(one);
		grup.add(two);
		grup.add(three);
	
		
		JRadioButton showpass = new JRadioButton("Show pass");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     if (showpass.isSelected()) {
	                    password.setEchoChar((char)0); //password = JPasswordField
	                } else {
	                    password.setEchoChar('*');
	                }
			}
		});
		
		
	
		
		
		showpass.setFont(new Font("Verdana", Font.PLAIN, 14));
		showpass.setBounds(309, 41, 115, 23);
		lgn.getContentPane().add(showpass);
		
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main f2 = new main();//admin sayfası
				usermain f3 = new usermain();//kullanıcı sayfası
				Manager_main f4 = new Manager_main(); //manager sayfası
				
				
				
				if(one.isSelected()) {
					
					login_query.login("SELECT * FROM users WHERE `user_username`=? AND `user_password`=?",usrname, password,f3,lgn);//kullanıcı sayfasına atar.
					f3.txt_username.setText(usrname.getText());
				}
				else if(two.isSelected()) {
					login_query.login_admin("SELECT * FROM admin WHERE `admin_username`=? AND `admin_password`=?",usrname, password,f2,lgn);//Admin sayfasına atar.
				}
				else if(three.isSelected()) {
					login_query.login_manager("SELECT * FROM manager WHERE `manager_username`=? AND `manager_password`=?",usrname,password,f4,lgn);
				}
				
			}
		}); 
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.setBounds(171, 96, 102, 23);
		lgn.getContentPane().add(btnNewButton);
		
		password = new JPasswordField();
		password.setFont(new Font("Verdana", Font.PLAIN, 14));
		password.setBounds(145, 42, 158, 20);
		lgn.getContentPane().add(password);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_up f2 = new sign_up();
				f2.setVisible(true);
				lgn.setVisible(false);
	
			}
		});
		btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSignUp.setBounds(309, 96, 100, 23);
		lgn.getContentPane().add(btnSignUp);
		
		
	
	}
}




