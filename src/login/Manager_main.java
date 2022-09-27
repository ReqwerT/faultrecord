package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.crud_op;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class Manager_main extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTextField txt_id;
	private JTextField txt_username;
	private JTextField txt_name;
	private JTextField txt_surname;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_main frame = new Manager_main();
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
	public Manager_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 641, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crud_op.List_admins("SELECT * FROM `admin`", table1);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 448, 169, 23);
		panel.add(btnNewButton);
		
		JButton btnUpdateAdmin = new JButton("Update Admin");
		btnUpdateAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String update = "UPDATE `admin` SET `admin_username`=?,`admin_name`=?,`admin_surname`=?,`admin_password`=? WHERE `admin_id`=?";
				char[] input = txt_password.getPassword();
				String passString = new String(input);  
				crud_op.Update_Admins(update,txt_id,txt_username,txt_name,txt_surname,passString);
				crud_op.List_admins("SELECT * FROM `admin`", table1);
			}
		});
		btnUpdateAdmin.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnUpdateAdmin.setBounds(10, 380, 169, 23);
		panel.add(btnUpdateAdmin);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crud_op.Add_admin("insert into admin (admin_username,admin_name,admin_surname,admin_password) values( '%s','%s','%s','%s')", txt_username, txt_name, txt_surname, txt_password);
					crud_op.List_admins("SELECT * FROM `admin`", table1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddAdmin.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAddAdmin.setBounds(10, 346, 169, 23);
		panel.add(btnAddAdmin);
		
		JButton btnRemoveAdmin = new JButton("Remove Admin");
		btnRemoveAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crud_op.Delete_admins("DELETE FROM `admin` WHERE admin_id=?",txt_id);
				crud_op.List_admins("SELECT * FROM `admin`", table1);
			}
		});
		btnRemoveAdmin.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRemoveAdmin.setBounds(10, 414, 169, 23);
		panel.add(btnRemoveAdmin);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_id.setBounds(148, 24, 157, 20);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_username.setColumns(10);
		txt_username.setBounds(148, 87, 157, 20);
		panel.add(txt_username);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_name.setColumns(10);
		txt_name.setBounds(148, 125, 157, 20);
		panel.add(txt_name);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(148, 160, 157, 20);
		panel.add(txt_surname);
		
		JLabel lblNewLabel = new JLabel("Admin Id:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel.setBounds(42, 26, 83, 14);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Username:");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName.setBounds(36, 89, 102, 14);
		panel.add(lblName);
		
		JLabel lblSurname = new JLabel("Name:");
		lblSurname.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSurname.setBounds(42, 127, 83, 14);
		panel.add(lblSurname);
		
		JLabel lblSurname_1 = new JLabel("Surname:");
		lblSurname_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSurname_1.setBounds(42, 162, 83, 14);
		panel.add(lblSurname_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPassword.setBounds(42, 193, 109, 14);
		panel.add(lblPassword);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, panel_1);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(148, 191, 157, 20);
		panel.add(txt_password);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 637, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 623, SpringLayout.WEST, contentPane);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 583, 575);
		panel_1.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   txt_id.setText(table1.getValueAt(table1.getSelectedRow(),0).toString());
			       txt_name.setText(table1.getValueAt(table1.getSelectedRow(),1).toString());
			       txt_surname.setText(table1.getValueAt(table1.getSelectedRow(),2).toString());
			       txt_username.setText(table1.getValueAt(table1.getSelectedRow(),3).toString());
			       txt_password.setText(table1.getValueAt(table1.getSelectedRow(),4).toString());
				
			}
		});
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Admin ID", "Admin Username", "Admin Name", "Admin Surname", "Admin Password"
			}
		));
		table1.getColumnModel().getColumn(1).setPreferredWidth(104);
		table1.getColumnModel().getColumn(3).setPreferredWidth(102);
		table1.getColumnModel().getColumn(4).setPreferredWidth(104);
		table1.setToolTipText("\r\n");
		table1.setSurrendersFocusOnKeystroke(true);
		table1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table1.setForeground(Color.MAGENTA);
		table1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		table1.setFillsViewportHeight(true);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		table1.setBorder(UIManager.getBorder("SplitPaneDivider.border"));
		table1.setBackground(Color.WHITE);
	}
}
