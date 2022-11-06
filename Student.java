package projectII;

public class Student {
	private int ID;
	private String email;
	
	public Student(int id, String email) {
		this.ID = id;
		this.email = email;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getEmail() {
		return email;
	}
}
