package login;

import java.awt.BorderLayout;
import login.lgn;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sign_up extends JFrame {

	private JPanel sign_up;
	private JTextField txt_name;
	private JTextField txt_mail;
	private JTextField txt_username;
	private JTextField txt_surname;
	private JPasswordField txt_password;
	private JLabel lblPassword;
	private JRadioButton showpass;
	private JButton btnSignUp;
	private JButton btnNewButton;
	private JLabel lblNumber;
	private JFormattedTextField txt_phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up frame = new sign_up();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sign_up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 400);
		sign_up = new JPanel();
		sign_up.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(sign_up);
		sign_up.setLayout(null);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_name.setBounds(139, 36, 126, 20);
		sign_up.add(txt_name);
		txt_name.setColumns(10);
		
		txt_mail = new JTextField();
		txt_mail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_mail.setBounds(139, 160, 126, 20);
		sign_up.add(txt_mail);
		txt_mail.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_username.setBounds(139, 98, 126, 20);
		sign_up.add(txt_username);
		txt_username.setColumns(10);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(139, 67, 126, 20);
		sign_up.add(txt_surname);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(85, 39, 54, 14);
		sign_up.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSurname.setBounds(69, 73, 70, 14);
		sign_up.add(lblSurname);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUserName.setBounds(53, 101, 86, 14);
		sign_up.add(lblUserName);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEmail.setBounds(85, 163, 54, 14);
		sign_up.add(lblEmail);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(139, 191, 126, 20);
		sign_up.add(txt_password);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setBounds(59, 192, 80, 14);
		sign_up.add(lblPassword);
		
		showpass = new JRadioButton("Show pass");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (showpass.isSelected()) {
	                    txt_password.setEchoChar((char)0); //password = JPasswordField
	                    
	                } else {
	                    txt_password.setEchoChar('*');
	                   
	                }
			}
		});
		showpass.setFont(new Font("Verdana", Font.PLAIN, 14));
		showpass.setBounds(235, 218, 115, 23);
		sign_up.add(showpass);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String sign_up = "INSERT INTO `users`( `user_username`, `user_name`, `user_surname`, `user_mail`, `user_phone`, `user_password`) VALUES (?,?,?,?,?,?)";
				try {
					crud_op.Sign_Up(sign_up,txt_username,txt_name,txt_surname,txt_mail,txt_phone,txt_password);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			
			}
		});
		
		btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSignUp.setBounds(129, 255, 96, 23);
		sign_up.add(btnSignUp);
		
		btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				lgn lgn = new lgn();
				lgn.lgn.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.setBounds(235, 255, 86, 23);
		sign_up.add(btnNewButton);
		
		lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumber.setBounds(69, 130, 61, 14);
		sign_up.add(lblNumber);
		
		txt_phone = new JFormattedTextField();
		txt_phone.setBounds(139, 129, 126, 20);
		sign_up.add(txt_phone);
	}
}



