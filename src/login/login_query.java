package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class login_query {

	
	
	public static void login(String asd,JTextField username,JPasswordField pass, JFrame frm , JFrame frm1 ) {
		String query=asd;//"SELECT * FROM userss WHERE `username`=? AND `user_password`=?";
		String logineposta = username.getText();
	    String loginpassword=String.valueOf(pass.getPassword());
	    
	    	PreparedStatement ps1;
	        ResultSet rs;
	       
	        try {
	             ps1=MyConnection.getConnection().prepareStatement(query);    
	             ps1.setString(1,logineposta);
	             ps1.setString(2,loginpassword);
	             rs=ps1.executeQuery();
	             if(rs.next())
	             {
	                 JOptionPane.showMessageDialog(null,"Giriş Başarılı,Kullanıcı Sayfasına yönlendiriliyorsunuz... ");
	                 frm.setVisible(true);
     				 frm1.dispose();
     				 
     		        }
	             else {
	            	 JOptionPane.showMessageDialog(null,"Giriş Başarısız! Şifre veya kullanıcı adı hatalı ");
	             }
	             
	                
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	}
	        }
	
	
	public static void login_admin(String asd,JTextField username,JPasswordField pass, JFrame frm , JFrame frm1 ) {
		String query=asd;
		String logineposta = username.getText();
	    String loginpassword=String.valueOf(pass.getPassword());
	        
	    	PreparedStatement ps1;
	        ResultSet rs;
	       
	        try {
	             ps1=MyConnection.getConnection().prepareStatement(query);    
	             ps1.setString(1,logineposta);
	             ps1.setString(2,loginpassword);
	             rs=ps1.executeQuery();
	             if(rs.next())
	             {
	                 JOptionPane.showMessageDialog(null,"Giriş Başarılı,Admin Sayfasına yönlendiriliyorsunuz... ");
	                 frm.setVisible(true);
     				 frm1.setVisible(false);
	             }
	             else {
	            	 JOptionPane.showMessageDialog(null,"Giriş Başarısız! Kullanıcı adı veya şifre hatalı ");
	             }
	             
	                
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	}
	        }

	public static void login_manager(String asd,JTextField username,JPasswordField pass, JFrame frm , JFrame frm1 ) {
		String query=asd;
		String logineposta = username.getText();
	    String loginpassword=String.valueOf(pass.getPassword());
	        
	    	PreparedStatement ps1;
	    	
	        ResultSet rs;
	       
	        try {
	             ps1=MyConnection.getConnection().prepareStatement(query);    
	             ps1.setString(1,logineposta);
	             ps1.setString(2,loginpassword);
	             rs=ps1.executeQuery();
	             if(rs.next())
	             {
	                 JOptionPane.showMessageDialog(null,"Login, you are redirected to SuccessManager Page... ");
	                 frm.setVisible(true);
     				 frm1.setVisible(false);
	             }
	             else {
	            	 JOptionPane.showMessageDialog(null,"Login Failed! Username or password is wrong... ");
	             }
	             
	                
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	}
	        }

}

