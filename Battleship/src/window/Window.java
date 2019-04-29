package window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import matrix.Matrix;
 
public class Window extends Application {
	
	
	//private Matrix matrix = new Matrix(10,10);
	Tile tile = new Tile();
	//Color myColor = Tile.getColor(matrix.getTile(1, 2).getRep());
	
	//This launches everything:
	public static void main(String[] args) {
		launch(Window.class, args);
		System.out.println(javafx.scene.text.Font.getFamilies());
		
	}
	
	//This makes everything show:
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*primaryStage.setScene(new Scene(Window());
		primaryStage.show();*/
		
		BorderPane border = new BorderPane();		//Adding new borderPane to organize shit
		HBox hbox = addHBox();						//Adding new HBox for my textarea (dunno if necessary)
		border.setLeft(hbox);						//Set hbox to the left
		border.setRight(addFlowPane());				//Adding flowPane to right (will later show ships)
		
		border.setCenter(addGridPane());			//Adding gridPane to center	

		//Makes everything visible
		Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BattleShip");
        primaryStage.show();
	}
	
	//TODO: Problem: How to get 2x GridPane in center
	//Our GridPane
	private Parent addGridPane() {
		GridPane root = new GridPane();
		root.setPrefSize(600,600);
		root.setPadding(new Insets(10, 10, 0, 10));
		
		//making 10x10
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 30);
				tile.setTranslateY(i * 30);
				root.getChildren().add(tile);			
			}
		}
		
		return root;		
	}
	
	
	
	public HBox addHBox() {
		Text text = new Text();
		text.setFont(new Font("Agency FB", 20));
		
		text.setText("Log:\n");
	    TextArea log = new TextArea();
	    HBox hbox = new HBox(text,log);
	    hbox.setPadding(new Insets(15, 15, 15, 15));
	    hbox.setPrefSize(200, 600);
	    hbox.setSpacing(1);
	    hbox.setStyle("-fx-background-color: #f0f8ff;");

	    /*Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);

	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);*/

	    return hbox;
	}
	
	public FlowPane addFlowPane() {
	    FlowPane flow = new FlowPane();
	    flow.setPadding(new Insets(15, 15, 15, 15));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    //flow.setPrefWrapLength(170); // preferred width allows for two columns
	    flow.setStyle("-fx-background-color: #f0f8ff;");

	    //TODO: Put in images later like this:
	    
	    /*ImageView pages[] = new ImageView[8];
	    for (int i=0; i<8; i++) {
	        pages[i] = new ImageView(
	            new Image(LayoutSample.class.getResourceAsStream(
	            "graphics/chart_"+(i+1)+".png")));
	        flow.getChildren().add(pages[i]);
	    }*/

	    return flow;
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