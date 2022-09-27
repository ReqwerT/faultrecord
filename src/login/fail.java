package login;

public class fail {
	  private int user_id;
	   private String Explanation,Process,Email,Status;
	   public fail(){
	       
	   }
	   
	   public fail(int user_id,String Explanation,String Process,String Status,String Email){
	       this.user_id=user_id;
	       this.Explanation=Explanation;
	       this.Process=Process; 
	       this.Status=Status; 
	       this.Email=Email; 
	   }
	   public int getid(){
	       return user_id;
	   }
	   public String getExplanation(){
	       return Explanation;
	       
	   }
	   public String getEmail() {
		   return Email;
	   }
	   public String getProcess(){
	       return Process;   
	   }
	   public String getStatus(){
	       return Status;
	   }
	   public int getUserid() {
		   return user_id;
	   }
	  
}
