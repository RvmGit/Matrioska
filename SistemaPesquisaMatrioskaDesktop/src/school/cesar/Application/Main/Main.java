package school.cesar.Application.Main;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import school.cesar.Data.DAO.Data;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
//			Parent root = FXMLLoader.load(getClass().getResource("../UI/MyFirstTest.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("../UI/SelectFileScreen.fxml"));
			primaryStage.setTitle("Matrioska Desktop");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		
//		for (String string : Data.readFile()) {
//			System.out.println(string);
//		}
	}
}
