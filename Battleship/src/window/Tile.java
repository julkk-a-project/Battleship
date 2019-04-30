package window;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
	
	
	private static Color[] colorList = {	//TODO: CUSTOMIZE COLOURS (NOT WORKING)
									new Color(0, 0, 1, 0.5), 	//blue = water
									new Color(1, 0, 0, 0.5),	//red = hit
									new Color(1, 1, 0, 0.5),	//miss = yellow
									new Color(0, 1, 1, 0.5),		//hull = gray
									new Color(1, 0, 1, 1),		//illogical = black
									};
	private Rectangle border;
	

	public Tile() {
		border = new Rectangle(20,20);
		border.setFill(/*getColor()*/Color.GHOSTWHITE);
		border.setStroke(Color.BLACK);
		
		Text text = new Text();
		text.setFont(Font.font(20));
		text.setVisible(true);
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, text);
	}
	
	
	
	public static Color getColor(int colorIndex) {
		Color color = colorList [colorIndex];
		return color;
	}



	public EventHandler<? super MouseEvent> setColor(Color color) {
		
		border.setFill(color);
		
		return null;
	}



	public void setOnAction(EventHandler<ActionEvent> eventHandler) {
		border.setOnKeyPressed(getOnKeyPressed());
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
