package window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
	//Tile tile = new Tile();
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
		MenuBar menu = new MenuBar();				//Adding new menuBar
		VBox vbox = addVBox();						//Adding new VBox for my textarea (dunno if necessary)
		
		border.setLeft(vbox);						//Adding vBox to the left
		border.setRight(addFlowPane());				//Adding flowPane to right (will later show ships)
		border.setCenter(addGridPane());			//Adding gridPane to center	
		border.setTop(addMenuBar());				//Adding menuBar to top

		//Makes everything visible
		Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BattleShip");
        primaryStage.show();
	}
	
	
	//Our GridPane
	private Parent addGridPane() {
		
		GridPane root = new GridPane();
		
		root.setPrefSize(300,600);							//set size of GridPane
		root.setPadding(new Insets(10, 10, 10, 5));			//set padding around	
		//root.setStyle("-fx-background-color: #a9a9a9;");	//Color of background
		root.setAlignment(Pos.TOP_CENTER);					//Position of Grid
		
		createBoard(root, 0, 0);
		createBoard(root, 0, 220);
		
		return root;		
	}
	
	
	//Creating an VBox (VBox arranges a series of nodes in a single column)
	public VBox addVBox() {
		
		Text text = new Text();
	    TextArea log = new TextArea();
	    VBox vbox = new VBox(text,log);
	    
	    log.setEditable(false);
	    
		text.setFont(new Font("Agency FB", 20));
		text.setText("Log:\n");
	    
	    vbox.setPadding(new Insets(15, 15, 15, 15));
	    vbox.setPrefSize(200, 600);
	    vbox.setSpacing(1);
	    vbox.setStyle("-fx-background-color: #f0f8ff;");

	    
	    //Saved in case I would need a button:
	    
	    /*Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);
	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);*/

	    return vbox;
	}
	
	
	//Creating FlowPane (In FlowPane the nodes are laid out consecutively and wrap at the boundary set for the pane.)
	public FlowPane addFlowPane() {
		

	    TextArea log = new TextArea();
	    FlowPane flow = new FlowPane(log);
	    
	    flow.setPadding(new Insets(15, 15, 15, 15));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    flow.setPrefWrapLength(170); // preferred width allows for two columns
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
	
	
	//Creating MenuBar
	public BorderPane addMenuBar() {
		
		BorderPane pane = new BorderPane();
		MenuBar menu = new MenuBar();
		
		
		//File
		Menu file = new Menu("File");				//Creates heading "File"
		
		MenuItem itmNew = new MenuItem("New");		//Creates subHeading "New"
		MenuItem itmSave = new MenuItem("Save");	//Creates subHeading "Save"
		MenuItem itmExit = new MenuItem("Exit");	//Creates subHeading "Exit"
		
		
		//Settings
		Menu settings = new Menu("Settings");				//Creates heading "Settings"
		
		MenuItem itmSettings = new MenuItem("Settings");	//Creates subHeading "Settings"

		
		//Help
		Menu help = new Menu("Help");				//Creates heading "Help"
		
		MenuItem itmHelp = new MenuItem("Help");	//Creates subHeading "Help"
		
		
		//Add items to each menu
		file.getItems().addAll(itmNew, itmSave, itmExit);
		settings.getItems().addAll(itmSettings);
		help.getItems().addAll(itmHelp);
		
		
		//Add Menus to MenuBar
		menu.getMenus().addAll(file,settings,help);
		pane.setTop(menu);
		
		
		return pane;
	}
	
	private void createBoard(GridPane root, int xOffSet, int yOffSet) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile1 = new Tile();
				
				tile1.setTranslateX(j * 20 + xOffSet);
				tile1.setTranslateY(i * 20 + yOffSet);
			
				root.getChildren().add(tile1);
			}
		}
		
		
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