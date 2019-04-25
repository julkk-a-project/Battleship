package window;

import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tile extends StackPane {
	
	
	
	public Tile() {
		Rectangle border = new Rectangle(30,30);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		
		Text text = new Text();
		text.setFont(Font.font(20));
		text.setVisible(true);
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, text);
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
