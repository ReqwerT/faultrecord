package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.product_fault;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.TextArea;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class usermain extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JPanel panel2;
	public JButton plus;
	public JTextField textField;
	private JTextField usr_id;
	public  JTextField txt_username;
	private JTextField txt_name;
	private JTextField txt_surname;
	private JTextField txt_mail;
	private JTextField txt_pass;
	private JTextField txt_phone;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermain frame = new usermain();
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
	public usermain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int user_id = Integer.parseInt(usr_id.getText());
				String List= "SELECT * FROM fault";
				
				crud_op.getInfo(usr_id, txt_username, txt_name, txt_surname, txt_mail, txt_pass, txt_phone);
				crud_op.List_userfault(List,table, usr_id);
				
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 816);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panels = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "My Fault Records", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(9, 506, 1079, 236);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 1067, 162);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"User ID", "Fault ID", "Explanation", "Process", "Situation", "User Mail"
			}
			
			
			
		));
		
		JButton btnNewButton_1_1 = new JButton("Delete Fault Record");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crud_op.RemoveFault(table.getValueAt(table.getSelectedRow(),1).toString());
					String List= "SELECT * FROM fault";
					crud_op.List_userfault(List,table, usr_id);
					JOptionPane.showMessageDialog(null, "Fault Deleted...");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(827, 185, 230, 40);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Fault Record", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(9, 16, 829, 478);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(115, 94, 113, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(238, 88, 245, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblFaultExplanation = new JLabel("Fault explanation:");
		lblFaultExplanation.setBounds(98, 179, 130, 24);
		panel_1.add(lblFaultExplanation);
		lblFaultExplanation.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		TextArea textArea = new TextArea();
		textArea.setBounds(234, 179, 418, 101);
		panel_1.add(textArea);
		textArea.setSelectionEnd(20);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setColumns(4);
		textArea.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Add Fault Record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add ="insert into fault (product_name,Explanation,user_id,user_mail,process,situation) values( '%s','%s','%d','%s','%s','%s')";
				try {
					crud_op.Add_userfault(add, txt_username,textArea,usr_id,txt_mail);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String List= "SELECT * FROM fault";
				crud_op.List_userfault(List,table, usr_id);
			}
		});
		btnNewButton_1.setBounds(253, 301, 230, 42);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User Settings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(861, 16, 233, 479);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JLabel lblPhone = new JLabel("phone:");
		lblPhone.setBounds(29, 333, 66, 24);
		panel_2.add(lblPhone);
		lblPhone.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("e-mail:");
		lblPassword.setBounds(29, 251, 48, 14);
		panel_2.add(lblPassword);
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 210, 74, 14);
		panel_2.add(lblSurname);
		lblSurname.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(22, 169, 57, 14);
		panel_2.add(lblName);
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblUsername_1 = new JLabel("User ID:");
		lblUsername_1.setBounds(10, 90, 85, 14);
		panel_2.add(lblUsername_1);
		lblUsername_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		usr_id = new JTextField();
		usr_id.setEditable(false);
		usr_id.setBounds(85, 84, 129, 30);
		panel_2.add(usr_id);
		usr_id.setText("12");
		usr_id.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setEditable(false);
		txt_username.setBounds(85, 122, 129, 30);
		panel_2.add(txt_username);
		txt_username.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setEditable(false);
		txt_name.setBounds(85, 163, 129, 30);
		panel_2.add(txt_name);
		txt_name.setColumns(10);
		
		txt_surname = new JTextField();
		txt_surname.setEditable(false);
		txt_surname.setBounds(85, 204, 129, 30);
		panel_2.add(txt_surname);
		txt_surname.setColumns(10);
		
		txt_mail = new JTextField();
		txt_mail.setEditable(false);
		txt_mail.setBounds(85, 245, 129, 30);
		panel_2.add(txt_mail);
		txt_mail.setColumns(10);
		
		txt_pass = new JTextField();
		txt_pass.setEditable(false);
		txt_pass.setBounds(85, 286, 129, 30);
		panel_2.add(txt_pass);
		txt_pass.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setEditable(false);
		txt_phone.setBounds(85, 332, 129, 30);
		panel_2.add(txt_phone);
		txt_phone.setColumns(10);
		
		JButton Update = new JButton("Apply");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user_id = Integer.parseInt(usr_id.getText());
				String List= "SELECT * FROM fault";
				try {
					crud_op.Update_User(usr_id,txt_username,txt_name,txt_surname,txt_mail,txt_phone,txt_pass);
					crud_op.List_userfault(List, table, usr_id);
					
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			
				
				
			}
		});
		Update.setBounds(119, 378, 102, 30);
		panel_2.add(Update);
		Update.setFont(new Font("Verdana", Font.PLAIN, 17));
		
		JLabel lblPassword_1 = new JLabel("password:");
		lblPassword_1.setBounds(10, 288, 85, 22);
		panel_2.add(lblPassword_1);
		lblPassword_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 128, 113, 14);
		panel_2.add(lblUsername);
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.getColumnModel().getColumn(2).setPreferredWidth(228);
	
		JRadioButton edit = new JRadioButton("Edit mode");

		edit.setBounds(10, 383, 97, 23);
		panel_2.add(edit);
		edit.setFont(new Font("Verdana", Font.PLAIN, 14));
		edit.setBackground(Color.GRAY);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(edit.isSelected()) {
					
					txt_name.setEditable(true);
					txt_surname.setEditable(true);
					txt_mail.setEditable(true);
					txt_phone.setEditable(true);
					txt_pass.setEditable(true);
					
				}
				else {
					
					txt_name.setEditable(false);
					txt_surname.setEditable(false);
					txt_mail.setEditable(false);
					txt_phone.setEditable(false);
					txt_pass.setEditable(false);
				}
			}
		});
	
	
	}
	
	
}
