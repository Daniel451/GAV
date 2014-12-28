package main.services;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller implements Initializable {
   
   @FXML
   private MenuBar _menuBar;
   
   @FXML
   private Pane _mainWindow;
   
   @FXML
   private ChoiceBox _choiceBox;
   
   @FXML
   private FlowPane _flowPane1;
   
   @FXML
   private FlowPane _flowPane2;
   
   @FXML
   private MenuItem _menuHelp_About;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      assert _menuBar != null : "_menuBar not connected! check FXML!";
      assert _mainWindow != null : "_mainWindow not connected! check FXML!";
      assert _choiceBox != null : "_choiceBox not connected! check FXML!";

      // Flowpanes an Fenstergröße anpassen
         _flowPane1.prefWidthProperty().bind(_mainWindow.widthProperty());
         _flowPane2.prefWidthProperty().bind(_mainWindow.widthProperty());
      
      // Menü an Fenstergröße anpassen
         _menuBar.prefWidthProperty().bind(_mainWindow.widthProperty());
         
      // Choicebox konfigurieren
         _choiceBox.setItems(FXCollections.observableArrayList(
               "Select an algorithm",
               new Separator(),
               "A-Star",
               "Breadth-First-Search",
               "Depth-First-Search"
               ));
         _choiceBox.getSelectionModel().selectFirst();
         
   }
   
   @FXML
   private void handleClick_Menu_Help_About(ActionEvent event)
   {
      String aboutText = "Graph Algorithm Visualizer"
            + "\n\n"
            + "Version: 0.1 (built 2014-06-18)"
            + "\n\n"
            + "Author: Daniel Speck"
            + "\n"
            + "-> 2speck@informatik.uni-hamburg.de"
            + "\n"
            + "-> daniel@dspeck.de";
      
      Stage dialog = new Stage();
      Scene scene = new Scene(
            new Group(
                  new Text(25, 25, aboutText)));
      dialog.setScene(scene);
      dialog.setTitle("About GAV");
      dialog.setWidth(400.0);
      dialog.setHeight(300.0);
      dialog.setResizable(false);
      dialog.show();
   }
   
}