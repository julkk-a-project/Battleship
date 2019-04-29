package window;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
 
public class Window extends Application {
	
	
	//private Matrix matrix = new Matrix(10,10);
	//Tile tile = new Tile();
	//Color myColor = Tile.getColor(matrix.getTile(1, 2).getRep());
	
	//This launches everything:
	public static void main(String[] args) {
		launch(Window.class, args);
		//System.out.println(javafx.scene.text.Font.getFamilies());			//Gets what fonts available
		
	}
	
	//This makes everything show:
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*primaryStage.setScene(new Scene(Window());
		primaryStage.show();*/
		
		BorderPane border = new BorderPane();		//Adding new borderPane to organize shit
		VBox vbox = addVBoxLeft();					//Adding new VBox for my textarea (dunno if necessary)
		
		border.setLeft(vbox);						//Adding vBox to the left
		border.setRight(addVBoxRight());			//Adding flowPane to right (will later show ships)
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
		
		Text text1 = new Text("Opponent");
		text1.setFont(new Font("Agency FB", 16));
		text1.setTranslateX(-100);
		text1.setVisible(true);
		root.add(text1, 0, 0);
		
		createBoard1(root, -100, 20, null);
		
		Text text2 = new Text("You");
		text2.setFont(new Font("Agency FB", 16));
		text2.setVisible(true);
		text2.setTranslateY(240);
		text2.setTranslateX(-100);
		root.add(text2, 0, 0);
		
		createBoard2(root, -100, 260);
		//TODO: Make tiles clickable
		
		return root;		
	}
	
	
	//Creating an VBox (VBox arranges a series of nodes in a single column)
	public VBox addVBoxLeft() {
		
		Text text = new Text();
	    TextArea log = new TextArea();
	    VBox vboxLeft = new VBox(text,log);
	    
	    log.setEditable(false);
	    
		text.setFont(new Font("Agency FB", 20));
		text.setText("Log: ");
	    
	    vboxLeft.setPadding(new Insets(15, 15, 15, 15));
	    vboxLeft.setPrefSize(200, 600);
	    vboxLeft.setSpacing(1);
	    vboxLeft.setStyle("-fx-background-color: #f0f8ff;");

	    
	    //Saved in case I would need a button:
	    
	    /*Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);
	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);*/

	    return vboxLeft;
	}
	
	
	//Creating FlowPane (In FlowPane the nodes are laid out consecutively and wrap at the boundary set for the pane.)
	public VBox addVBoxRight() {
		

	    TextArea log = new TextArea();
	    VBox vBoxRight = new VBox(log);
	    
	    log.setEditable(false);
	    
	    vBoxRight.setPadding(new Insets(15, 15, 15, 15));
	    vBoxRight.setPrefSize(200, 600);
	    vBoxRight.setSpacing(1);
	    vBoxRight.setStyle("-fx-background-color: #f0f8ff;");
	    
	   
	    
	    //TODO: Put in images later like this:
	    /*ImageView pages[] = new ImageView[8];
	    for (int i=0; i<8; i++) {
	        pages[i] = new ImageView(
	            new Image(LayoutSample.class.getResourceAsStream(
	            "graphics/chart_"+(i+1)+".png")));
	        flow.getChildren().add(pages[i]);
	    }*/

	    return vBoxRight;
	}
	
	
	//Creating MenuBar
	public BorderPane addMenuBar() {
		
		BorderPane pane = new BorderPane();
		MenuBar menu = new MenuBar();
		
		//File
		Menu file = new Menu("_File");				//Creates heading "File"
		MenuItem itmNew = new MenuItem("New");		//Creates subHeading "New"
		MenuItem itmOpen = new MenuItem("Open...");		//Creates subHeading "New"
		MenuItem itmSave = new MenuItem("Save");	//Creates subHeading "Save"
		MenuItem itmExit = new MenuItem("Exit");	//Creates subHeading "Exit"
		
		
		//Settings
		Menu settings = new Menu("_Settings");				//Creates heading "Settings"
		MenuItem itmSettings = new MenuItem("Settings");	//Creates subHeading "Settings"
		
		CheckMenuItem itmSound = new CheckMenuItem("Sound");
		CheckMenuItem itmWhatever = new CheckMenuItem("Whatever");
		itmSound.setSelected(true);
		

		//Help
		Menu help = new Menu("Help");				//Creates heading "Help"		
		MenuItem itmHelp = new MenuItem("Help");	//Creates subHeading "Help"
		
		//Add items to each menu
		file.getItems().addAll(itmNew, itmOpen, itmSave, new SeparatorMenuItem(), itmExit);
		settings.getItems().addAll(itmSound, new SeparatorMenuItem(), itmWhatever);
		help.getItems().addAll(itmHelp);	
		
		//Add Menus to MenuBar
		menu.getMenus().addAll(file,settings,help);
		pane.setTop(menu);
		
		//Cool stuff
		file.setMnemonicParsing(true);				//Use Alt+F to open 'File' or Alt+S ti open 'Settings'
		
		
		/* Could have used CONTROL_DOWN for the code that follows, but if someone is using Mac this would cause problem
		 * so therefore SHORTCUT_DOWN is a better solution. In PC it's CTRL, mac CMND etc...
		 */
		
		itmNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));			//CTRL+N for new game	
		itmOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));		//CTRL+N for new game	
		itmSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));		//CTRL+S for save
		itmExit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN));		//CTRL+Q for Exit //TODO: Remember to ask if player really want this

		itmSound.setAccelerator(new KeyCodeCombination(KeyCode.M, 
													   KeyCombination.SHIFT_DOWN, 
													   KeyCombination.SHORTCUT_DOWN));					//CTRL+SHIFT+M for selecting sound on/off
		
		itmHelp.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN));		//CTRL+H for help
		
		
		//Some action to 'File'-menu
		NewGame newGame = new NewGame(); //TODO: Wanted to open new window, but can't do that yet
		itmNew.setOnAction(e -> System.out.println("Creates new game"));
		
		
		//Adding Listeners
		itmSound.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				if(newValue) {
					if(itmSound.isSelected()) {
						//Write what happens
					}else {
						//write what happens
					}
				} else {
					//Write what happens
				}
			}
		});
		
		return pane;
	}
	
	//TODO: EventHandler: What should happen when you click the mouse on a tile
	private void createBoard1(GridPane root, int xOffSet, int yOffSet, EventHandler<? super MouseEvent> handler) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile1 = new Tile();
				
				tile1.setTranslateX(j * 20 + xOffSet);
				tile1.setTranslateY(i * 20 + yOffSet);
				tile1.setOnMouseClicked(handler);
			
				root.getChildren().add(tile1);
			}
		}
	}
	
	
	private void createBoard2(GridPane root, int xOffSet, int yOffSet) {

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				Tile tile1 = new Tile();

				tile1.setTranslateX(j * 20 + xOffSet);
				tile1.setTranslateY(i * 20 + yOffSet);

				root.getChildren().add(tile1);
			}
		}
	}
}