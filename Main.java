package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Main extends Application{

	
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root, 400, 400);
		//scene.getStylesheets().add(getClass().getResource("application.css"));
		primaryStage.setScene(scene);
        primaryStage.show();
	}
	public static void main(String[] args)
    {
         launch(args);
    }

}
