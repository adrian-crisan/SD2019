package ro.utcn.sd;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) throws IOException {
    	
    	launch(args);
    }


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 Parent fxml = FXMLLoader.load(getClass().getResource("/Login.fxml"));
	     Scene scene = new Scene(fxml);
	     primaryStage.sizeToScene();
	     primaryStage.setScene(scene);
	     primaryStage.show();
		
	}   
}
