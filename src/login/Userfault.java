package login;

public class Userfault {
	int user_id,fault_id;
	String explanation , process , situation , user_mail;
	
	public Userfault(int user_id,int fault_id , String explanation,String process, String situation, String user_mail) {
		this.user_id = user_id;
		this.fault_id = fault_id;
		this.explanation = explanation;
		this.process = process;
		this.situation = situation;
		this.user_mail=user_mail;
	}
	
	public int getUserID() {
		return user_id;
	}
	public int getFaultID() {
		return fault_id;
	}
	public String getExplanation() {
		return explanation;
	}
	public String getProcess() {
		return process;
	}
	public String getSituation() {
		return situation;
	}
	public String getMail() {
		return user_mail;
	}
	
	
}
