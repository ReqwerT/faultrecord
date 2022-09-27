package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class product_fault extends JFrame {
	//ürün ile ilgili bilgiler burada yer alacak.
	private JPanel contentPane;
	private JTextField product_id;
	private JTextField product_name;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_fault frame = new product_fault();
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
	public product_fault() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		product_id = new JTextField();
		product_id.setFont(new Font("Verdana", Font.PLAIN, 16));
		product_id.setBounds(162, 42, 186, 27);
		contentPane.add(product_id);
		product_id.setColumns(10);
		
		product_name = new JTextField();
		product_name.setFont(new Font("Verdana", Font.PLAIN, 16));
		product_name.setColumns(10);
		product_name.setBounds(162, 103, 186, 27);
		contentPane.add(product_name);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(162, 164, 186, 27);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 48, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblProductName.setBounds(10, 109, 122, 14);
		contentPane.add(lblProductName);
		
		JLabel lblDateOfRe = new JLabel("Date of Receipt:");
		lblDateOfRe.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblDateOfRe.setBounds(10, 170, 141, 21);
		contentPane.add(lblDateOfRe);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermain asd =new usermain();
				
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.setBounds(92, 202, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancel.setBounds(235, 202, 133, 23);
		contentPane.add(btnCancel);
	}

}
