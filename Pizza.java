package projectII;

public class Pizza {
	private String pizzaType;
	private String[] pizzaToppings;
	
	public Pizza(String type, String[] toppings) {
		this.pizzaType = type;
		this.pizzaToppings = toppings;
	}
	
	public String getPizzaType() {
		return pizzaType;
	}
	
	public String[] getPizzaToppings() {
		return pizzaToppings;
	}
	
	public void setPizzaType(String type) {
		this.pizzaType = type;
	}
	
	public void setPizzaType(String[] toppings) {
		this.pizzaToppings = toppings;
	}
}
