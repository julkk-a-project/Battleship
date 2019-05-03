package window;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Tile extends StackPane {
	public boolean isOpen;
	private Text text = new Text("A");
	
	private static Color[] colorList = {	//CUSTOMIZED COLORS
									new Color(0, 0, 1, 1.0), 		//blue = water
									new Color(1, 0, 0, 1.0),		//red = hit
									new Color(1, 1, 0, 1.0),		//miss = yellow
									new Color(1, 1, 1, 0.7),		//hull = gray
									new Color(1, 1, 1, 1.0),		//illogical = black
									};
	private Rectangle border;

	private static Color color;

	public Tile() {
		border = new Rectangle(20,20);
		border.setFill(/*getColor()*/Color.GHOSTWHITE);
		border.setStroke(Color.BLACK);
		
		
		
		text.setFont(Font.font(14));
		text.setVisible(true);
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, text);
		setOnMouseClicked(event -> open());
		close();
	}
	
	
	
	public static Color getColor(int colorIndex) {
		color = colorList [colorIndex];
		return color;
	}



	public Rectangle setColor(Color color) {
		border.setFill(color);
		
		return border;
	}



	public void setOnAction(EventHandler<ActionEvent> eventHandler) {
		border.setOnMouseClicked(event -> open());
	}
	
	
	
	public void open() {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.6),setColor(color));
		ft.setToValue(1);
		ft.play();
		
	}
	
	public void close() {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.6),text);
		ft.setToValue(0);
		ft.play();
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
