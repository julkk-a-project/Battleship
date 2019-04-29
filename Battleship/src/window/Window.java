package window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import matrix.Matrix;
 
public class Window extends Application {
	
	
	//private Matrix matrix = new Matrix(10,10);
	Tile tile = new Tile();
	//Color myColor = Tile.getColor(matrix.getTile(1, 2).getRep());
	
	
	public static void main(String[] args) {
		launch(Window.class, args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*primaryStage.setScene(new Scene(Window());
		primaryStage.show();*/
		
		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setLeft(hbox);
		border.setCenter(createContent());
		
		
		Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BattleShip");
        primaryStage.show();
		
	}
	
	
	private Parent createContent() {
		GridPane root = new GridPane();
		root.setPrefSize(600,600);
		root.setPadding(new Insets(10, 10, 0, 10));
	
		
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 30);
				tile.setTranslateY(i * 30);
				root.getChildren().add(tile);			
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 30);
				tile.setTranslateY(i * 30);
				root.getChildren().add(tile);			
			}
		}
		root.setGridLinesVisible(true);
		return root;		
	}
	
	
	
	public HBox addHBox() {
	    TextArea textArea = new TextArea();
	    HBox hbox = new HBox(textArea);
	    hbox.setPadding(new Insets(30, 30, 30, 30));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #f0f8ff;");

	    /*Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);

	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);*/

	    return hbox;
	}
 
    /*SOME OLD SHIT
     
    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("BattleShip");
        stage.setWidth(300);
        stage.setHeight(300);
 
        final Label label = new Label("BattleShip");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(false);
        
        char c = 'A';
        for(int i = 0; i < 10; i++) {
        	TableColumn column = new TableColumn(String.valueOf(c));
        	table.getColumns().addAll(column);
        	
        	c++;
        	 
        }
        for(int i = 0; i< 10; i++) {
            TableRow row = new TableRow(Integer.valueOf(i));
            
        	
        }
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }*/
}