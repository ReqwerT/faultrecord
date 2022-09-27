package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class userview_List {
	
	public static void List_Fault(JTextField id,JTable table) {
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
        model.setNumRows(0);
        Object[] row=new Object[6];
        for (int i = 0; i < faults.size(); i++) {
            row[0]=faults.get(i).getUserID();
            row[1]=faults.get(i).getFaultID();
            row[2]=faults.get(i).getExplanation();
            row[3]=faults.get(i).getProcess();
            row[4]=faults.get(i).getSituation();
            
            
            
            model.addRow(row);
	}
	}
	
	public static void List_UserInfo(JTextField id,JTextField username,JTextField user_name,JTextField user_surname,JTextField user_mail,JTextField user_phone) {
		ArrayList<User>users=new ArrayList<>();
		int id1= Integer.parseInt(id.getText());
	
        String query="SELECT * FROM `users` where user_id="+id1;
        try {
                //HATA VAR DÜZELT
            PreparedStatement ps=MyConnection.getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            User user;
            while(rs.next()){
                
            
            user=new User(rs.getInt("user_id"),rs.getString("user_username"),rs.getString("user_name"),rs.getString("user_surname"),rs.getString("user_mail"),rs.getString("user_password"),rs.getString("user_phone"));
               users.add(user);
            }
            username.setText(users.get(0).getUsername());
            user_name.setText(users.get(0).getName());
            user_surname.setText(users.get(0).getSurname());
            user_mail.setText(users.get(0).getEmail());
            user_phone.setText(users.get(0).getNumber());

        } catch (Exception e) {
        }
       
        
       
        
        
    }
	}
	

