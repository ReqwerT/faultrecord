package login;

import java.awt.Label;
import java.awt.TextArea;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class crud_op extends JFrame{
	static Connection con;
	
	
	public crud_op() {
		
	}
	
	//çalışıyor
	public static void Delete(String del, JTextField asd ) {
		String id=asd.getText();
        String query=del;
        PreparedStatement ps;
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(0, id);
                ps.executeUpdate();
                if(ps.executeUpdate()==0){
                    JOptionPane.showMessageDialog(null,"Deleted");
                    
                }
               
                
        } catch (Exception e) {
        }
	}
	
	
	//kullanıcının hatasını çekme
	public static void List_userfault(String list,JTable table, JTextField id) {
		ArrayList<Userfault>faults=new ArrayList<>();
		int id1 = Integer.parseInt(id.getText());
        String query="SELECT * FROM fault where user_id="+id1;
        
        try {
               
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
           
            Userfault fault;
            while(rs.next()){
                
            
            fault=new Userfault(rs.getInt("user_id"),rs.getInt("fault_id"),rs.getString("explanation"),rs.getString("process"),rs.getString("situation"),rs.getString("user_mail"));
               faults.add(fault);
            }

            
        } catch (Exception e) {
        }
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setNumRows(1);
        Object[] row=new Object[6];
        for (int i = 0; i < faults.size(); i++) {
            row[0]=faults.get(i).getUserID();
            row[1]=faults.get(i).getFaultID();
            row[2]=faults.get(i).getExplanation();
            row[3]=faults.get(i).getProcess();
            row[4]=faults.get(i).getSituation();
            row[5]=faults.get(i).getMail();
            
            
            model.addRow(row);
	}
	}
	
	public static void RemoveFault(String faultID) throws SQLException {
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");  
        try{

            int id1=Integer.parseInt(faultID);  
            
            String sorgu=String.format("delete from fault where fault_id=%d",id1);
            java.sql.Statement stmt=con.createStatement(); 
            int silindi = stmt.executeUpdate(sorgu);  
            System.out.println("Fault Deleted");
            
        }catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
	}
	
	
	public static void Add_user(JTextField username,JTextField name,JTextField surname,JTextField mail,JTextField phone,JTextField password) throws SQLException {
		String usrname=username.getText(); 
		String name1=name.getText(); 
		String srname=surname.getText(); 
		String usermail = mail.getText();
		String usrphone =phone.getText() ;
		String pass =password.getText() ;
		
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");
		 String query="insert into users(user_username,user_name,user_surname,user_mail,user_phone,user_password) values( '%s','%s','%s','%s','%s','%s')"; ;
		 PreparedStatement ps;
	     ResultSet rs;
	     try{
        	 java.sql.Statement stmt= con.createStatement(); 
            String sorgu=String.format(query,usrname,name1,srname,usermail,usrphone,pass); 
            int ekleme = ((java.sql.Statement) stmt).executeUpdate(sorgu);
            JOptionPane.showMessageDialog(null, "User Added...");
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);;}
	}
	
	public static void Remove_user(JTextField id) throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");  
        try{

            int id1=Integer.parseInt(id.getText());  
            
            String sorgu=String.format("delete from users where user_id=%d",id1);
            java.sql.Statement stmt=con.createStatement(); 
            int silindi = stmt.executeUpdate(sorgu);  
            System.out.println("Kayıtlar Silindi");
            
        }catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
	}
	 
	public static void Update_User(JTextField id,JTextField username,JTextField name,JTextField surname,JTextField mail,JTextField phone,JTextField password) throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");  
        try{
          int usr_id=Integer.parseInt(id.getText());
          String usrname=username.getText();
          String usr_name=name.getText();
          String usr_surname=surname.getText();
          String usr_mail=mail.getText();
          String usr_phone=phone.getText();
          String usr_pass=password.getText();
          
            
            String sorgu=String.format("update users set user_username='%s',user_name='%s',user_surname='%s',user_mail='%s',user_phone='%s',user_password='%s' where user_id=%d ", usrname,usr_name,usr_surname,usr_mail,usr_phone,usr_pass,usr_id) ;
            
            java.sql.Statement stmt=con.createStatement(); 
            int guncelleme = stmt.executeUpdate(sorgu);  
            JOptionPane.showMessageDialog(null,"Update Succesfully");
        }catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
    }
	
	
	public static void Add_userfault(String add,JTextField product_name,TextArea textArea,JTextField user_id,JTextField usr_mail) throws SQLException {
		String pn=product_name.getText(); 
		String exp=textArea.getText(); 
		int userid=Integer.parseInt(user_id.getText());
		String usermail = usr_mail.getText();
		String proc = " ";
		String sit = " ";
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");
		 String query=add;
		 PreparedStatement ps;
	     ResultSet rs;
	     try{
        	 java.sql.Statement stmt= con.createStatement(); 
            String sorgu=String.format(add,pn,exp,userid,usermail,proc,sit); //add ="insert into admin values( '%s','%s','%s','%s','%s')"; 
            int ekleme = ((java.sql.Statement) stmt).executeUpdate(sorgu);
            JOptionPane.showMessageDialog(null, "Fault Added...");
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);;}
	}
	
	//çalışıyor
	public static void List(String list,JTable table){
		ArrayList<User>users=new ArrayList<>();
        String query=list;//list = "SELECT * FROM `kullanıcılar`"
        try {
                //HATA VAR DÜZELT
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            User user;
            while(rs.next()){
                
            
            user=new User(rs.getInt("user_id"),rs.getString("user_username"),rs.getString("user_name"),rs.getString("user_surname"),rs.getString("user_mail"),rs.getString("user_password"),rs.getString("user_phone"));
               users.add(user);
            }

            
        } catch (Exception e) {
        }
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setNumRows(1);
        Object[] row=new Object[7];
        for (int i = 0; i < users.size(); i++) {
            row[0]=users.get(i).getid();
            row[1]=users.get(i).getUsername();
            row[2]=users.get(i).getName();
            row[3]=users.get(i).getSurname();
            row[4]=users.get(i).getEmail();
            row[5]=users.get(i).getPassword();
            row[6]=users.get(i).getNumber();
            
            model.addRow(row);
           
        
        
    }
	}
	
	public static void List_ariza(String list,JTable table){
		ArrayList<Userfault>fails=new ArrayList<>();
		ArrayList<User>users=new ArrayList<>();
        String query=list;//list = "SELECT * FROM `fault,users`"
        try {
                
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Userfault Fail;
            User user;
            while(rs.next()){
                
            
            Fail=new Userfault(rs.getInt("user_id"),rs.getInt("fault_id"),rs.getString("Explanation"),rs.getString("Process"),rs.getString("Situation"),rs.getString("user_mail"));
               fails.add(Fail);
           
            }

            
        } catch (Exception e) {
        }
         DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setNumRows(1);
        Object[] row=new Object[6];
        for (int i = 0; i < fails.size(); i++) {
            row[1]=fails.get(i).getFaultID();
            row[2]=fails.get(i).getExplanation();
            row[3]=fails.get(i).getProcess();
            row[4]=fails.get(i).getSituation();
            row[0]=fails.get(i).getUserID();
            row[5]=fails.get(i).getMail();
            
       
            model.addRow(row);
           
           
            
        
    }

     
       
        
	}

    //kullanıcılar için ekleme işlemi
	public static void Adduser(JTextField username,JTextField name, JTextField surname , JTextField mail, JTextField phone,JTextField pass) {
	
		String name1=name.getText(); 
		String surname1=surname.getText(); 
		String email=mail.getText(); 
		String num=phone.getText();
		String usern1=username.getText();
		String passw=pass.getText();
		String query = "insert into users (user_username,user_name,user_surname,user_mail,user_phone,user_password) values("+usern1+","+name1+","+surname1+","+email+","+num+","+passw+")";
		 
		 PreparedStatement ps;
	     ResultSet rs;
		
        try{
        	ps=MyConnection.getConnection().prepareStatement(query);
            String sorgu=String.format(query,usern1,name1,surname1,mail,num,passw);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Kayıt Eklendi...");
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
        System.out.println(e);;
        
        }
		
	}
	
	//adminler için ekleme iş
	public static void Add_admin(String add,JTextField user_name,JTextField name, JTextField surname , JPasswordField password) throws SQLException
	//Adminler için ekleme işlemi 
	{
		String ad=name.getText(); 
		String soyad=surname.getText(); 
		String username = user_name.getText();
		char[] input =  password.getPassword();
        String passString = new String(input);
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fault_record0","root","");
		
        try{
        	 java.sql.Statement stmt= con.createStatement(); 
            String sorgu=String.format(add,username,ad,soyad,passString); //add ="insert into admin values( '%s','%s','%s','%s','%s')"; 
            int ekleme = ((java.sql.Statement) stmt).executeUpdate(sorgu);
            JOptionPane.showMessageDialog(null, "Kayıt Eklendi...");
        }catch(Exception e){ JOptionPane.showMessageDialog(null, e);;}
		
		
	}
	
	//kullanıcılar için update
	public static void Update(JTextField id1,JTextField name1,JTextField username1 ,JTextField surname1, JTextField e_mail1 , JTextField number1) 
	{
		String id=id1.getText();
        String username=username1.getText();
        String name=name1.getText();
        String surname=surname1.getText();
        String email=e_mail1.getText();
        String number=number1.getText();
        
        String query="UPDATE `users` SET `user_username`,`user_name`,`user_surname`,`user_mail`,`user_phone` WHERE `user_id`";
        PreparedStatement ps;
        ResultSet rs;
       
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(1,username);
                ps.setString(2,name);
                ps.setString(3,surname);
                ps.setString(4,email);
                ps.setString(5,number);
                ps.setString(6,id);
                ps.executeQuery();
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Succesfully");  
                }
                
        } catch (Exception e) {
        }

	}

	public static void getInfo(JTextField id,JTextField user_username ,JTextField user_name ,JTextField user_surname ,JTextField user_mail ,JTextField user_pass , JTextField phone ) {
		ArrayList<User>users=new ArrayList<>();
		User user;
		String username = user_username.getText();
        String query="SELECT * FROM users WHERE `user_username`=?";
        int id1;
		
	    
	    
	    	PreparedStatement ps1;
	        ResultSet rs;
	       
	        try {
	             ps1=MyConnection.getConnection().prepareStatement(query);    
	             ps1.setString(1,username);     
	             rs=ps1.executeQuery();
	             
	             
	             if(rs.next())
	             {
	            	 user=new User(rs.getInt("user_id"),rs.getString("user_username"),rs.getString("user_name"),rs.getString("user_surname"),rs.getString("user_mail"),rs.getString("user_password"),rs.getString("user_phone"));
	                 users.add(user);
	                 
	                 for (int i = 0; i < users.size(); i++) {
	                     id1 =(users.get(i).getid());
	                     System.out.println(id1);
	                     String ids = Integer.toString(id1);
	                     System.out.println(ids);
	                     id.setText(ids);
	                     user_name.setText(users.get(i).getName());
	                     user_surname.setText(users.get(i).getSurname());
	                     user_mail.setText(users.get(i).getEmail());
	                     phone.setText(users.get(i).getNumber());
	                     user_pass.setText(users.get(i).getPassword());
	                    
	                     
	                 
	             }


     		        }
	             else {
	            	 JOptionPane.showMessageDialog(null,"Giriş Başarısız! Şifre veya kullanıcı adı hatalı ");
	             }
	             
	                
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	}
      
        
           
	      
	}

	public static void List_admins(String list,JTable table){
		ArrayList<Admin>admin=new ArrayList<>();
        String query=list;//list = "SELECT * FROM `admin`"
        try {
                //HATA VAR DÜZELT
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Admin admins;
            while(rs.next()){
                
            
            admins=new Admin(rs.getInt("admin_id"),rs.getString("admin_username"),rs.getString("admin_name"),rs.getString("admin_surname"),rs.getString("admin_password"));
               admin.add(admins);
            }

            
        } catch (Exception e) {
        }
         DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setNumRows(1);
        
        
        Object[] row=new Object[5];
        for (int i = 0; i < admin.size(); i++) {
            row[0]=admin.get(i).getId();
            row[1]=admin.get(i).getUsername();
            row[2]=admin.get(i).getName();
            row[3]=admin.get(i).getSurname();
            row[4]=admin.get(i).getPassword();
            
            
            model.addRow(row);
  
    }
	}

	public static void  Delete_admins(String del,JTextField asd) {
		  
		        //Admin Silme işlemi
		
		String id=asd.getText();
       
        String query=del;
        PreparedStatement ps;
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();
                if(ps.executeUpdate()==0){
                    JOptionPane.showMessageDialog(null,"Deleted");
                    
                }
               
                
        } catch (Exception e) {
        }
		    
	}
	
	public static void Update_Admins(String update,JTextField admin_id,JTextField admin_username,JTextField admin_name ,JTextField admin_surname, String admin_password ) {
		String id=admin_id.getText();
        String username=admin_username.getText();
        String name=admin_name.getText();
        String surname=admin_username.getText();
        
        String query="UPDATE `admin` SET `admin_username`=?,`admin_name`=?,`admin_surname`=?,`admin_password`=? WHERE `admin_id`=?";
        PreparedStatement ps;
        ResultSet rs;
       
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(1,username);
                ps.setString(2,name);
                ps.setString(3,surname);
                ps.setString(4,admin_password);
                ps.setString(5,id);
                ps.executeUpdate();
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Succesfully");  
                }
                
        } catch (Exception e) {
        }
		
	}

	public static void Sign_Up(String sign_up,JTextField txt_username,JTextField txt_name,JTextField txt_surname,JTextField txt_mail,JTextField txt_phone,JPasswordField txt_password) {
			String username=txt_username.getText();
			String name=txt_name.getText();    
			String surname=txt_surname.getText();
	        String mail=txt_mail.getText();
	        String phone=txt_phone.getText();
	        String pass=String.valueOf(txt_password.getPassword());
		
		PreparedStatement ps;
        String query=sign_up;
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(1,username);
                ps.setString(2,name);
                ps.setString(3,surname);
                ps.setString(4,mail);
                ps.setString(5,phone);
                ps.setString(6,pass);
                
                  if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"New user Add");}
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,e);
        }
	}
	
	
	public static void upd_fault(TextArea textArea_1, String situation, String fault_id) {
		int fi = Integer.parseInt(fault_id);
        String process=textArea_1.getText();
     
        String query="UPDATE `fault` SET `process`=?,`situation`=? WHERE `fault_id`=?";
        PreparedStatement ps;
        ResultSet rs;
       
        try {
                ps=MyConnection.getConnection().prepareStatement(query);
                ps.setString(1,process);
                ps.setString(2,situation);              
                ps.setString(3,fault_id);
                ps.executeUpdate();
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Update Succesfully");  
                }
                
        } catch (Exception e) {
        }
		
	}
	
	
	
}

