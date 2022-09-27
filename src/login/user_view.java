package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import login.main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import login.crud_op;

public class user_view extends JFrame {
	private JTable table;
	private JTextField usr_id;
	private JTextField user_name;
	private JTextField user_mail;
	private JTextField user_username;
	private JTextField user_surname;
	private JTextField User_Phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_view frame = new user_view();
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
	public user_view() {
		
		setBounds(100, 100, 952, 560);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 76, 874, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 854, 248);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "Fault ID", "Explanation", "Process", "Situation"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Fault Records:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 29));
		lblNewLabel.setBounds(26, 41, 327, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUserId.setBounds(26, 380, 116, 24);
		getContentPane().add(lblUserId);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUserName.setBounds(26, 429, 146, 24);
		getContentPane().add(lblUserName);
		
		JLabel lblUserMail = new JLabel("User Mail:");
		lblUserMail.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUserMail.setBounds(26, 481, 116, 24);
		getContentPane().add(lblUserMail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUsername.setBounds(573, 380, 136, 24);
		getContentPane().add(lblUsername);
		
		JLabel lblUserSurname = new JLabel("User Surname:");
		lblUserSurname.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUserSurname.setBounds(531, 429, 187, 24);
		getContentPane().add(lblUserSurname);
		
		JLabel lblUserMail_1 = new JLabel("User Phone:");
		lblUserMail_1.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblUserMail_1.setBounds(545, 481, 152, 24);
		getContentPane().add(lblUserMail_1);
		
		usr_id = new JTextField();
		usr_id.setEditable(false);
		usr_id.setFont(new Font("Verdana", Font.PLAIN, 14));
		usr_id.setBounds(167, 380, 187, 28);
		getContentPane().add(usr_id);
		usr_id.setColumns(10);
		
		user_name = new JTextField();
		user_name.setEditable(false);
		user_name.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_name.setColumns(10);
		user_name.setBounds(166, 425, 187, 28);
		getContentPane().add(user_name);
		
		user_mail = new JTextField();
		user_mail.setEditable(false);
		user_mail.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_mail.setColumns(10);
		user_mail.setBounds(167, 477, 187, 28);
		getContentPane().add(user_mail);
		
		user_username = new JTextField();
		user_username.setEditable(false);
		user_username.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_username.setColumns(10);
		user_username.setBounds(719, 376, 187, 28);
		getContentPane().add(user_username);
		
		user_surname = new JTextField();
		user_surname.setEditable(false);
		user_surname.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_surname.setColumns(10);
		user_surname.setBounds(719, 429, 187, 28);
		getContentPane().add(user_surname);
		
		User_Phone = new JTextField();
		User_Phone.setEditable(false);
		User_Phone.setFont(new Font("Verdana", Font.PLAIN, 14));
		User_Phone.setColumns(10);
		User_Phone.setBounds(719, 481, 187, 28);
		getContentPane().add(User_Phone);
		
		JLabel usrid = new JLabel("User ID:");
		usrid.setFont(new Font("Verdana", Font.PLAIN, 23));
		usrid.setBounds(801, 11, 99, 24);
		getContentPane().add(usrid);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {		
				usr_id.setText(main.table.getValueAt(main.table.getSelectedRow(),0).toString());
				usrid.setText(main.table.getValueAt(main.table.getSelectedRow(),0).toString());
				
				userview_List asd = new userview_List();
				asd.List_UserInfo(usr_id, user_username, user_name, user_surname, user_mail, User_Phone);
				asd.List_Fault(usr_id, table);
				
				
				
				
			}
		});

	}
}
