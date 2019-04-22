package window;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Window extends Application {
 
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
        
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}