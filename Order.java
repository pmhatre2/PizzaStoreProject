package projectII;

public class Order {
	private String orderStatus, pickupTime;
	private Pizza pizza;
	private Student student;
	
	public Order(Student student, Pizza pizza, String status, String time) {
		
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public void setStatus(String status) {
		this.orderStatus = status;
	}
	public void setTime(String time) {
		this.pickupTime = time;
	}
	
	public Student getStudent() {
		return student;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public String getStatus() {
		return orderStatus;
	}
	public String getTime() {
		return pickupTime;
	}
}
