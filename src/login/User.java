package login;
//veritabanından gelen verileri tutmak için oluşturulmuştur.
public class User {
	   public int id;
	   public String user_username,user_name,user_surname,user_mail,user_password,user_phone;
	   public User(){
	       
		   
	   }
	   public User(int id,String user_username,String user_name,String user_surname,String user_mail,String user_password,String user_phone){
	       this.id=id;
	       this.user_username=user_username;
	       this.user_name=user_name;
	       this.user_surname=user_surname;
	       this.user_mail=user_mail;
	       this.user_password=user_password;
	       this.user_phone=user_phone;
	       
	   }
	   
	   public int getid(){
	       return id;
	   }
	   
	   public String getUsername() {
		   return user_username;
	   }
	   
	   public String getName(){
	       return user_name;
	       
	   }
	   public String getSurname(){
	       return user_surname;
	       
	   }
	   public String getEmail(){
	       return user_mail;
	   }
	   public String getPassword(){
	       return user_password;
	   }
	   public String getNumber(){
	       return user_phone;
	   }
}
