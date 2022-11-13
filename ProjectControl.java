package Project;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ProjectControl {
	@FXML private RadioButton Chef;
	@FXML private TextField ID;
	@FXML private RadioButton ProcessingAgent;
	@FXML private RadioButton Student;
	@FXML private Button loginButton;
	@FXML private ToggleGroup selections;
	@FXML private RadioButton Cheese;
	@FXML private RadioButton Pepperoni;
	@FXML private RadioButton Hawaiian;
	@FXML private RadioButton Margherita;
	@FXML private Button pizzaTypeButton;
	@FXML private CheckBox Mushrooms;
	@FXML private CheckBox Pepperonis;
	@FXML private CheckBox Peppers;
	@FXML private CheckBox Onions;
	@FXML private CheckBox Pineapple;
	@FXML private CheckBox Olives;
	@FXML private Button pizzaToppingsButton;
	@FXML private TextField text;
	@FXML private Button orderConfirmButton;
	@FXML private TextField order1;
	@FXML private Button refreshButton;
	@FXML private Button clearButton;
	@FXML private Button refreshButton2;
	@FXML private TextField acceptedOrder1;
	@FXML private TextField acceptedOrder2;
	@FXML private TextField acceptedOrder3;
	@FXML private TextField acceptedOrder4;
	@FXML private TextField orderStatus1;
	@FXML private TextField orderStatus2;
	@FXML private TextField orderStatus3;
	@FXML private TextField orderStatus4;
	@FXML private Button cookingButton1;
	@FXML private Button cookingButton2;
	@FXML private Button cookingButton3;
	@FXML private Button cookingButton4;
	@FXML private Button readyButton1;
	@FXML private Button readyButton2;
	@FXML private Button readyButton3;
	@FXML private Button readyButton4;
	private Stage stage;
	private Scene scene;
	private Parent root;
	int id = 0;

	public void validate(ActionEvent e) throws IOException {
		String chosenUser = "";
		if(Chef.isSelected()) {
			chosenUser = "Chef";
		} else if(ProcessingAgent.isSelected()) {
			chosenUser = "ProcessingAgent";
		} else if(Student.isSelected()) {
			chosenUser = "Student";
		}
		
		Student s = new Student();
		Chef chef = new Chef();
		ProcessingAgent processingAgent = new ProcessingAgent();
		
		boolean checkID;
		
		id = Integer.parseInt(ID.getText());

		if(chosenUser == "Student") {
			checkID = Notifications.checkValidIDStudent(ID.getText());
			if(ID.getText().length() != 10) 
				checkID = false;
			
			if(checkID) {
				s.setID(id);
				root = FXMLLoader.load(getClass().getResource("PizzaSelection.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				stage.setUserData(s);
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
				root = FXMLLoader.load(getClass().getResource("retryLoginScreen.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		if(chosenUser == "Chef") {
			checkID = Notifications.checkValidIDChef(ID.getText());
			if(ID.getText().length() != 10) 
				checkID = false;
			
			if(checkID) {
				chef.setID(id);
				root = FXMLLoader.load(getClass().getResource("ChefHomePage.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				stage.setUserData(s);
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
				root = FXMLLoader.load(getClass().getResource("retryLoginScreen.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		if(chosenUser == "ProcessingAgent") {
			checkID = Notifications.checkValidIDProcessingAgent(ID.getText());
			if(ID.getText().length() != 10) 
				checkID = false;
			
			if(checkID) {
				processingAgent.setID(id);
				root = FXMLLoader.load(getClass().getResource("ProcessingAgentScreen.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				stage.setUserData(processingAgent);
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
				root = FXMLLoader.load(getClass().getResource("retryLoginScreen.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		
	}
	
	public void confirmPizzaType(ActionEvent e) throws IOException {
		Node node = (Node) e.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Student s = (Student) stage.getUserData();
		
		Pizza pizza = new Pizza();
		if(Cheese.isSelected()) {
			pizza.setPizzaType("Cheese");
		} else if(Pepperoni.isSelected()) {
			pizza.setPizzaType("Pepperoni");
		} else if(Hawaiian.isSelected()) {
			pizza.setPizzaType("Hawaiian");
		} else if(Margherita.isSelected()) {
			pizza.setPizzaType("Margherita");
		}
		
		Order order = new Order(s, pizza, "ACCEPTED", "0");

		root = FXMLLoader.load(getClass().getResource("PizzaToppingSelection.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setUserData(order);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show(); 
	}
	
	public void confirmPizzaToppings(ActionEvent e) throws IOException {
		Node node = (Node) e.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Order o = (Order) stage.getUserData();
		
		ArrayList<String> toppings = new ArrayList<String>();
		if(Mushrooms.isSelected()) 
			toppings.add("Mushrooms");
		if(Pepperonis.isSelected()) 
			toppings.add("Pepperoni");
		if(Peppers.isSelected()) 
			toppings.add("Peppers");
		if(Onions.isSelected()) 
			toppings.add("Onions");
		if(Pineapple.isSelected())
			toppings.add("Pineapple");
		if(Olives.isSelected())
			toppings.add("Olives");
		
		o.getPizza().setPizzaToppings(toppings);
				
		root = FXMLLoader.load(getClass().getResource("OrderDetails.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setUserData(o);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show(); 
	}
	
	public void displayOrderStatus(ActionEvent e) throws IOException {
		Node node = (Node) e.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Order o = (Order) stage.getUserData();
		
		String time = text.getText();
		
		o.setTime(time);
		
		System.out.println(o.toString());
		
		//Notifications.writeOrder(o);
		root = FXMLLoader.load(getClass().getResource("acceptScreen.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show(); 
	}
	
	public void refresh(ActionEvent e) throws IOException {
		order1.setText("Order 1");
		acceptedOrder1.setText("Order 1");
		acceptedOrder2.setText("Order 2");
		acceptedOrder3.setText("Order 3");
		acceptedOrder4.setText("Order 4");
		orderStatus1.setText("Order 1");
		orderStatus2.setText("Order 2");
		orderStatus3.setText("Order 3");
		orderStatus4.setText("Order 4");
	}
	
	public void pushButton(ActionEvent e) throws IOException {
		order1.clear();
	}
	
}
