package window;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewGame extends Application{
	
	BorderPane border = new BorderPane();	
	
	public static void main(String[] args) {
		launch(NewGame.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//border.setCenter(addGridPane());			//Adding gridPane to center	
		
	    
	    Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("New Game");
        primaryStage.show();
		
		
	}
	
	public NewGame() {
		border.setCenter(load());
		
		
	    //root.getChildren().addAll(buttonNewGame, buttonCancel);
		
		
				
		
	}

	public Parent load() {
		GridPane root = new GridPane();
		Text text = new Text();
		text.setFont(new Font("Agency FB", 20));
		text.setText("Create New Game: ");
		
		Text textSubheading = new Text();
		textSubheading.setFont(new Font("Agency FB", 14));
		textSubheading.setText("Player Name: ");
		
		Text textSubheading2 = new Text();
		textSubheading2.setFont(new Font("Agency FB", 14));
		textSubheading2.setText("Choose opponent: ");
		
		TextField name = new TextField();
		name.setFont(new Font("Agency FB", 12));
		name.autosize();
		
		
		root.setPrefSize(360,290);							//set size of GridPane
		root.setPadding(new Insets(10, 10, 10, 5));			//set padding around	
		//root.setStyle("-fx-background-color: #a9a9a9;");	//Color of background
		root.setAlignment(Pos.TOP_LEFT);					//Position of Grid
		
		/////////////
		// Buttons //
		/////////////
		
		Button buttonNewGame = new Button("Start Game");
		buttonNewGame.setPrefSize(90, 20);
		buttonNewGame.setTranslateX(0);
		buttonNewGame.setTranslateY(100);
		
		Button buttonCancel = new Button("Cancel");
	    buttonCancel.setPrefSize(90, 20);
	    buttonCancel.setTranslateX(10);
	    buttonCancel.setTranslateY(100);
	    
	    
	    
	               
	    buttonCancel.setCancelButton(true);
	    buttonCancel.setOnAction(e -> {
	    	Stage stage = (Stage) buttonCancel.getScene().getWindow();
		    stage.close();
	        System.out.println("Cancel clicked.");
	    });
	    
	   
	    
	    buttonNewGame.setOnAction(new EventHandler<ActionEvent>() {
	    	 
            public void handle(ActionEvent event) {
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("BattleShip");
            	alert.setHeaderText("Game Window");
            	alert.setContentText("This will be the game window eventually");

            	alert.showAndWait();
            }
        });
	    

		///////////////////
		// RadionButtons //
		///////////////////
	    
	    final ToggleGroup group = new ToggleGroup();
	    RadioButton rb1 = new RadioButton("Computer");
	    rb1.setToggleGroup(group);
	    rb1.setSelected(true);
	    rb1.setTranslateX(0);
		rb1.setTranslateY(10);
	    
	    RadioButton rb2 = new RadioButton("Player 2");
	    rb2.setToggleGroup(group);
	    rb2.setTranslateX(0);
		rb2.setTranslateY(15);
	    
	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	        public void changed(ObservableValue<? extends Toggle> ov,
	            Toggle old_toggle, Toggle new_toggle) {
	               /* if (group.getSelectedToggle() != null) {
	                    final Image image = new Image(
	                        getClass().getResourceAsStream(
	                            group.getSelectedToggle().getUserData().toString() + 
	                                ".jpg"
	                        )
	                    );
	                    icon.setImage(image);
	                }     */           
	            }
	    });
	    
	    root.add(text, 0, 0);
	    root.add(textSubheading, 0, 1);
	    root.add(name, 1, 1);
	    root.add(textSubheading2, 0, 3);
	    root.add(rb1, 1, 2);
	    root.add(rb2, 1, 3);
	    root.add(buttonNewGame, 1, 4);
	    root.add(buttonCancel, 2, 4);
	    
		return root;
	}

	
	
	/*private Parent addGridPane() {
		
		
		
	}*/

}
