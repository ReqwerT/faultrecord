package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.mail.MessagingException;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import java.awt.TextArea;
import java.awt.Window;

import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.SystemColor;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLayeredPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseMotionAdapter;

public class main extends JFrame {

	private JPanel contentPaneAdmin;
	public static JTable table1;
	public static JTable table;
	public static JTextField txt_id;
	private JTextField txt_username;
	private JTextField txt_name;
	private JTextField txt_surname;
	private JTextField txt_mail;
	private JTextField txt_phone;
	private JTextField txt_usermail;
	private JTextField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void get_value(){
        
    }
	
	
	    

	/**
	 * Create the frame.
	 */
	public main() {
		
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 888);
		contentPaneAdmin = new JPanel();
		contentPaneAdmin.setForeground(Color.WHITE);
		contentPaneAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAdmin);
		contentPaneAdmin.setLayout(null);

		
		ButtonGroup grup = new ButtonGroup();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			
			
				 			}
			
		});
		
		JLayeredPane pnlfault = new JLayeredPane();
		pnlfault.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fault Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlfault.setBounds(619, 30, 552, 647);
		contentPaneAdmin.add(pnlfault);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(37, 52, 465, 174);
		pnlfault.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea_1.setForeground(new Color(0, 0, 0));
		textArea_1.setBounds(37, 267, 465, 183);
		pnlfault.add(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("Explanation:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 32, 91, 14);
		pnlfault.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Process:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 249, 72, 14);
		pnlfault.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Situation:");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 467, 72, 14);
		pnlfault.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Choose-", "We Got It", "Being Repaired", "Repaired", "Out of Warranty"}));
		
		comboBox.setBounds(95, 465, 185, 29);
		pnlfault.add(comboBox);
		
		
	
		JButton btnList_1_1_2 = new JButton("View User Profile");
		btnList_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_view asd = new user_view();
				asd.setVisible(true);
			}
		});
		btnList_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnList_1_1_2.setBounds(105, 534, 196, 23);
		pnlfault.add(btnList_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("User Mail:");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(290, 469, 72, 14);
		pnlfault.add(lblNewLabel_1_1_1_1);
		
		txt_usermail = new JTextField();
		txt_usermail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_usermail.setEditable(false);
		txt_usermail.setBounds(372, 466, 170, 28);
		pnlfault.add(txt_usermail);
		txt_usermail.setColumns(10);
		
		JLabel fault_id = new JLabel("Process:");
		fault_id.setFont(new Font("Verdana", Font.PLAIN, 14));
		fault_id.setBounds(10, 609, 72, 14);
		pnlfault.add(fault_id);
		
	
		JButton btnList_1_1_1 = new JButton("Update Fault Record");
		btnList_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnList_1_1_1.setBounds(105, 505, 196, 23);
		pnlfault.add(btnList_1_1_1);
		
		JButton removefault = new JButton("Remove Fault");
		removefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crud_op.RemoveFault(table.getValueAt(table.getSelectedRow(),1).toString());
					crud_op.List_ariza("SELECT * FROM `fault`",table);
					JOptionPane.showMessageDialog(null, "Fault Deleted...");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		removefault.setFont(new Font("Verdana", Font.PLAIN, 14));
		removefault.setBounds(105, 568, 196, 23);
		pnlfault.add(removefault);
		
		btnList_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String asd = comboBox.getSelectedItem().toString();
				crud_op.upd_fault(textArea_1,asd,fault_id.getText());
				String situ = "Ürün "+asd;
				List mail = new ArrayList();
				mail.add(txt_usermail.getText());
				MailSend.mailsend(situ, textArea_1.getText(), mail);
				
				
			}
		});
		
		tabbedPane.setFont(new Font("Verdana", Font.PLAIN, 14));
		tabbedPane.setBounds(27, 5, 582, 672);
		
		 
		contentPaneAdmin.add(tabbedPane);
		
		JPanel user = new JPanel();

		user.setToolTipText("");
		tabbedPane.addTab("Users", new ImageIcon("C:\\Users\\reqwe\\Downloads\\Hopstarter-Sleek-Xp-Basic-User-Group.ico"), user, null);
		user.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 532, 592);
		user.add(scrollPane);
		
		
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
			table1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					   txt_id.setText(table1.getValueAt(table1.getSelectedRow(),0).toString());
					   txt_username.setText(table1.getValueAt(table1.getSelectedRow(),1).toString());
				       txt_name.setText(table1.getValueAt(table1.getSelectedRow(),2).toString());
				       txt_surname.setText(table1.getValueAt(table1.getSelectedRow(),3).toString());
				       txt_mail.setText(table1.getValueAt(table1.getSelectedRow(),4).toString());
				       txt_phone.setText(table1.getValueAt(table1.getSelectedRow(),5).toString());
				       txt_pass.setText(table1.getValueAt(table1.getSelectedRow(),6).toString());
				      
				}
			});
		table1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table1.setBorder(UIManager.getBorder("SplitPaneDivider.border"));
		table1.setSurrendersFocusOnKeystroke(true);
		table1.setForeground(Color.MAGENTA);
		table1.setToolTipText("\r\n");
		table1.setBackground(Color.WHITE);
		table1.setCellSelectionEnabled(true);
		table1.setColumnSelectionAllowed(true);
		table1.setFillsViewportHeight(true);
		table1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"User ID", "Username", "Name", "Surname", "e-mail", "Phone Number", "Password"
			}
		));
		
		
		
		JPanel fault_redords = new JPanel();
		tabbedPane.addTab("Fault Records", null, fault_redords, null);
		fault_redords.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(21, 11, 530, 580);
		fault_redords.add(scrollPane_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(table.getValueAt(table.getSelectedRow(),2).toString());
				textArea_1.setText(table.getValueAt(table.getSelectedRow(),3).toString());
				txt_usermail.setText(table.getValueAt(table.getSelectedRow(),5).toString());
				fault_id.setText(table.getValueAt(table.getSelectedRow(),1).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"User ID", "Fault ID", "Explanation", "Process", "Situation", "User Mail"
			}
		));
		scrollPane_2.setViewportView(table);
		table.setToolTipText("\r\n");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setForeground(Color.MAGENTA);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(UIManager.getBorder("SplitPaneDivider.border"));
		table.setBackground(Color.WHITE);
		
		
		
		JLayeredPane pnluser = new JLayeredPane();
		pnluser.setBorder(new TitledBorder(null, "User Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnluser.setBounds(622, 30, 552, 647);
		contentPaneAdmin.add(pnluser);
		pnluser.setLayout(null);
		
		JButton Add = new JButton("Add User");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					crud_op.Add_user(txt_username,txt_name,txt_surname,txt_mail,txt_phone,txt_pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				crud_op.List("SELECT * FROM users",table1);
				
			}
		});
		Add.setFont(new Font("Verdana", Font.PLAIN, 14));
		Add.setBounds(112, 376, 128, 23);
		pnluser.add(Add);
		
		JButton Update = new JButton("Update User");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					crud_op.Update_User(txt_id,txt_name,txt_username,txt_surname,txt_mail,txt_phone,txt_pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				crud_op.List("SELECT * FROM users",table1);
				
			}
		});
		Update.setFont(new Font("Verdana", Font.PLAIN, 14));
		Update.setBounds(112, 444, 128, 23);
		pnluser.add(Update);
		
		JButton Remove = new JButton("Remove User");
		Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					crud_op.Remove_user(txt_id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				crud_op.List("SELECT * FROM users",table1);
				
			}
		});
		Remove.setFont(new Font("Verdana", Font.PLAIN, 14));
		Remove.setBounds(112, 410, 128, 23);
		pnluser.add(Remove);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_id.setBounds(112, 93, 150, 23);
		pnluser.add(txt_id);
		txt_id.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_username.setColumns(10);
		txt_username.setBounds(112, 127, 150, 23);
		pnluser.add(txt_username);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_name.setColumns(10);
		txt_name.setBounds(112, 161, 150, 23);
		pnluser.add(txt_name);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(112, 197, 150, 23);
		pnluser.add(txt_surname);
		
		txt_mail = new JTextField();
		txt_mail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_mail.setColumns(10);
		txt_mail.setBounds(112, 239, 150, 23);
		pnluser.add(txt_mail);
		
		JLabel lblNewLabel = new JLabel("User ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(43, 94, 59, 23);
		pnluser.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsername.setBounds(20, 128, 82, 23);
		pnluser.add(lblUsername);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblName.setBounds(43, 162, 59, 23);
		pnluser.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSurname.setBounds(31, 198, 71, 23);
		pnluser.add(lblSurname);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEmail.setBounds(43, 240, 59, 23);
		pnluser.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPhone.setBounds(43, 281, 59, 23);
		pnluser.add(lblPhone);
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_phone.setColumns(10);
		txt_phone.setBounds(112, 280, 150, 23);
		pnluser.add(txt_phone);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Verdana", Font.PLAIN, 14));
		pass.setBounds(20, 327, 82, 23);
		pnluser.add(pass);
		
		txt_pass = new JTextField();
		txt_pass.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt_pass.setColumns(10);
		txt_pass.setBounds(112, 326, 150, 23);
		pnluser.add(txt_pass);
		table1.getColumnModel().getColumn(5).setPreferredWidth(111);
		
		JButton btnList = new JButton("List");
		btnList.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnList.setBounds(445, 606, 110, 23);
		user.add(btnList);
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crud_op.List("SELECT * FROM users",table1);
				
				System.out.println(tabbedPane.getSelectedIndex());
			}
		});
		
		JButton btnList_1 = new JButton("List");
		btnList_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crud_op.List_ariza("SELECT * FROM `fault`",table);
			
				
			}
		});
		btnList_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnList_1.setBounds(441, 602, 110, 23);
		fault_redords.add(btnList_1);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				pnluser.setVisible(true);
				pnlfault.setVisible(false);
				fault_id.setVisible(false);
				
				crud_op.List_ariza("SELECT * FROM `fault`",table);
				crud_op.List("SELECT * FROM users",table1);
				if(tabbedPane.getSelectedIndex()==0) {
					pnluser.setVisible(true);
					pnlfault.setVisible(false);
				}
				else if(tabbedPane.getSelectedIndex()==1) {
					pnluser.setVisible(false);
					pnlfault.setVisible(true);
				}
			}
		});
	
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			
			}
		});
	
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(tabbedPane.getSelectedIndex()==0) {
					pnluser.setVisible(true);
					pnlfault.setVisible(false);
				}
				else if(tabbedPane.getSelectedIndex()==1) {
					pnluser.setVisible(false);
					pnlfault.setVisible(true);
				}
			}
		});
	
	
	
	
	
	
	
	}
}
