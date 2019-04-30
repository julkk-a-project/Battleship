package window;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
	    VBox vBoxLeft = new VBox(text,log);
	    
	    log.setEditable(false);
	    
		text.setFont(new Font("Agency FB", 20));
		text.setText("Log: ");
	    
	    vBoxLeft.setPadding(new Insets(15, 15, 15, 15));
	    vBoxLeft.setPrefSize(200, 600);
	    vBoxLeft.setSpacing(1);
	    vBoxLeft.setStyle("-fx-background-color: #f0f8ff;");

	    
	    //Saved in case I would need a button:
	    
	    /*Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);
	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);*/

	    return vBoxLeft;
	}
	
	
	//Creating FlowPane (In FlowPane the nodes are laid out consecutively and wrap at the boundary set for the pane.)
	public VBox addVBoxRight() {
		
		Text text = new Text();
	    Text subHeading = new Text();
	    Image img1 = new Image("skepp1.jpg", 100, 100, true, false);
	    Image img2 = new Image("skepp2.jpg", 100, 100, true, false);
	    Image img3 = new Image("skepp3.jpg", 100, 100, true, false);
	    Image img4 = new Image("skepp4.jpg", 100, 100, true, false);
	    Image img5 = new Image("skepp5.jpg", 100, 100, true, false);
	    
	    VBox vBoxRight = new VBox(text, subHeading, 
	    						  new ImageView(img1),
	    						  new ImageView(img2), 
	    						  new ImageView(img3), 
	    						  new ImageView(img4), 
	    						  new ImageView(img5));
	    	    
	    //log.setEditable(false);
	    
		text.setFont(new Font("Agency FB", 20));
		text.setText("Ships: ");
		
		subHeading.setFont(new Font("Agency FB", 14));
		subHeading.setText("Battleship:");
		
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
		MenuItem itmNew = new MenuItem("New Game");		//Creates subHeading "New"
		MenuItem itmOpen = new MenuItem("Open...");		//Creates subHeading "New"
		MenuItem itmSave = new MenuItem("Save");	//Creates subHeading "Save"
		MenuItem itmExit = new MenuItem("Exit");	//Creates subHeading "Exit"
		
		
		//Settings
		Menu settings = new Menu("_Settings");						//Creates heading "Settings"
		//**Not Used** MenuItem itmSettings = new MenuItem("Settings");	//Creates subHeading "Settings"
		CheckMenuItem itmSound = new CheckMenuItem("Sound");		//Creates checkMenu "Sound"
		CheckMenuItem itmWhatever = new CheckMenuItem("Whatever");	//Creates checkMenu "Whatever"
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
		
		
		//////////////////////////////////
		//Some action to 'File'-menu	//
		//////////////////////////////////
		
		//ActionEvent for click on 'New Game'
		NewGame newGame = new NewGame(); 
		itmNew.setOnAction((event) -> {
		    //try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("NewWindow.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         */
		        Scene scene = new Scene(newGame.load(), 600, 400);
		        Stage stage = new Stage();
		        stage.setTitle("New Game");
		        stage.setScene(scene);
		        stage.show();
		   /* } catch (IOException e) {
		        Logger logger = Logger.getLogger(getClass().getName());
		        logger.log(Level.SEVERE, "Failed to create new Window.", e);
		    }*/
		});
		
		//////////////////////////////////////
		//Some action to 'Settings'-menu	//
		//////////////////////////////////////
		
		//TODO: Finish these if-else-statements:
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