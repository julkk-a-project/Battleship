package window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("BattleShip");
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 275);
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		
		primaryStage.setScene(scene);
		//Button btn = new Button();
		//btn.setText("Say 'Hi'");
		//btn.setOnAction(new EventHandler<ActionEvent>() {

			//@Override
			//public void handle(ActionEvent event) {
				//System.out.println("Hailo!");
			
		//});

		StackPane root = new StackPane();
		//root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

}
