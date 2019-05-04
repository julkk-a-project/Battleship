package window;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import matrix.Matrix;

public class NewGame extends Application{
	
	BorderPane border = new BorderPane();	
	

	public NewGame() {
		border.setCenter(load());	
	}
	
	
	
	public static void main(String[] args) {
		launch(NewGame.class, args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Sets everything visible
	    Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("New Game");
        primaryStage.show();	
	}
	
	
	

	
	
	public Parent load() {
		
		GridPane root = new GridPane();
		final ToggleGroup group = new ToggleGroup();
	    
		Text text = new Text("Create New Game: ");			//Create text
		text.setFont(new Font("Agency FB", 20));			//set font and size		
		
		Text plyrName = new Text("Player Name: ");			//Create text
		plyrName.setFont(new Font("Agency FB", 14));		//set font and size
		
		Text textSubheading2 = new Text("Choose opponent: ");//Create text
		textSubheading2.setFont(new Font("Agency FB", 14));	//set font and size
		
		TextField name = new TextField();					//Create textField
		name.setFont(new Font("Agency FB", 12));			//set font and size
		name.autosize();									//autosize textfield
		
		root.setPrefSize(360,290);							//set size of GridPane
		root.setPadding(new Insets(10, 10, 10, 5));			//set padding around	
		root.setAlignment(Pos.TOP_LEFT);					//Position of Grid
		
		
		/////////////
		// Buttons //
		/////////////
		
		Button buttonNewGame = new Button("Start Game");
		buttonNewGame.setPrefSize(90, 20);					//set size of Button
		buttonNewGame.setTranslateX(0);						//Position of Button X-axis
		buttonNewGame.setTranslateY(100);					//Position of Button Y-axis
		
		Button buttonCancel = new Button("Cancel");
	    buttonCancel.setPrefSize(90, 20);					//set size of Button
	    buttonCancel.setTranslateX(10);						//Position of Button X-axis
	    buttonCancel.setTranslateY(100);					//Position of Button Y-axis
	    buttonCancel.setCancelButton(true);					//Set button to be a 'Cancel-button'

	    RadioButton rb1 = new RadioButton("Computer");
	    rb1.setToggleGroup(group);							//Set to toggle group
	    rb1.setSelected(true);								//Set autoSelected
	    rb1.setTranslateX(0);								//Position of RadioButton X-axis
		rb1.setTranslateY(10);								//Position of RadioButton Y-axis
	    
	    RadioButton rb2 = new RadioButton("Player 2");
	    rb2.setToggleGroup(group);							//Set to toggle group
	    rb2.setTranslateX(0);								//Position of RadioButton X-axis
		rb2.setTranslateY(15);								//Position of RadioButton Y-axis
	    
		
		/////////////////////////////
		// Some Action for Buttons //
		/////////////////////////////
		
		//'Name'-field
		//plyrName.setUserData(Object value);	//maybeShould use this to get the userData? Not sure.
		
		//'RadioButton'-buttons
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
	    
		
		//'New Game'-button
	    buttonNewGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	main.Main.myMatrix = new Matrix(10,10);
            	main.Main.myMatrix.putHull(3);
            }
        });

	    //'Cancel'-button
	    buttonCancel.setOnAction(e -> {
	    	Stage stage = (Stage) buttonCancel.getScene().getWindow();
		    stage.close();
	        System.out.println("Cancel clicked.");
	    });
	    
	    
	    
	    
	    //////////////////////////////////
	    //	Adding stuff too GridPane	//
	    //////////////////////////////////
	    
	    root.add(text, 0, 0);
	    root.add(plyrName, 0, 1);
	    root.add(name, 1, 1);
	    root.add(textSubheading2, 0, 3);
	    root.add(rb1, 1, 2);
	    root.add(rb2, 1, 3);
	    root.add(buttonNewGame, 1, 4);
	    root.add(buttonCancel, 2, 4);
	    
		return root;
	}
}
