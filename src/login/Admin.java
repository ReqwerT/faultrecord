package login;

public class Admin {
	private int id;
	private String admin_username,admin_name,admin_surname,admin_password;
	
	public Admin(int id,String admin_username,String admin_name, String admin_surname,String admin_password) {
		this.id = id;
		this.admin_name=admin_name;
		this.admin_username=admin_username;
		this.admin_surname=admin_surname;
		this.admin_password=admin_password;
	}
	
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return admin_username;
	}
	public String getName() {
		return admin_name;
		
	}
	public String getSurname() {
		return admin_surname;
	}
	public String getPassword() {
		return admin_password;
	}

}
