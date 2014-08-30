package main.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
   
   private Stage _primaryStage;
   private Pane _mainPane;
   private Scene _mainScene;
   
   public static void main(String[] args) {
      launch(args);
   }
   
	@Override
	public void start(Stage primaryStage) {
		try {
			_primaryStage = primaryStage;
		   
		   _mainPane = FXMLLoader.load(getClass().getResource("mainframe.fxml"));  
		   _mainScene = new Scene(_mainPane, 800, 400);
			_mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// load Test-Vertex
			_mainPane.getChildren().add(FXMLLoader.load(getClass().getResource("vertex.fxml")));
			
			_primaryStage.setScene(_mainScene);
			_primaryStage.setTitle("GAV - Graph Algorithm Visualizer");
			_primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
