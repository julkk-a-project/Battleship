package window;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tile extends StackPane {
	
	public Tile(String value) {
		Rectangle border = new Rectangle(50,50);
		border.setFill(null);
		border.setStroke(Color.WHITESMOKE);
		
		Text text = new Text();
	}

	/*public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		
	}
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(1000,650);
		
		return root;
		
	}*/

}
