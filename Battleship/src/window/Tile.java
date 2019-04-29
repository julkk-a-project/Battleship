package window;

import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tile extends StackPane {
	
	
	/*private static Color[] colorList = {	//TODO: CUSTOMIZE COLOURS (NOT WORKING)
									new Color(15, 47, 255, 0.5), 	//blue = water
									new Color(255, 15, 15, 0.5),	//red = hit
									new Color(238, 250, 20, 0.5),	//miss = yellow
									new Color(4, 2, 13, 0.5),		//hull = gray
									new Color(14, 14, 0, 1),		//illogical = black
									};*/
	

	public Tile() {
		Rectangle border = new Rectangle(20,20);
		border.setFill(/*getColor()*/null);
		border.setStroke(Color.BLACK);
		
		Text text = new Text();
		text.setFont(Font.font(20));
		text.setVisible(true);
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, text);
	}
	
	
	/*public static Color getColor(int colorIndex) {
		Color color = colorList [colorIndex];
		return color;
	}*/
	
	
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
