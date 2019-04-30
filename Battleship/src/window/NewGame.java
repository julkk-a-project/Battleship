package window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		border.setCenter(addGridPane());
	}

	
	
	private Parent addGridPane() {
		
		
		GridPane root = new GridPane();
		
		
		root.setPrefSize(200,300);							//set size of GridPane
		root.setPadding(new Insets(10, 10, 10, 5));			//set padding around	
		//root.setStyle("-fx-background-color: #a9a9a9;");	//Color of background
		root.setAlignment(Pos.TOP_CENTER);					//Position of Grid
		
		Button buttonNewGame = new Button("New Game");
		buttonNewGame.setPrefSize(100, 20);
	    buttonNewGame.setTranslateY(20);
		
		Button buttonCancel = new Button("Cancel");
	    buttonCancel.setPrefSize(100, 20);
	    buttonCancel.setTranslateY(30);
	    
	    root.add(buttonNewGame, 0, 0);
	    root.add(buttonCancel, 0, 2);
	    
	    //root.getChildren().addAll(buttonNewGame, buttonCancel);
		
		
		return root;		
	}

}
