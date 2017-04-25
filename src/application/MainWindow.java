/* Main.hava */
// initializes main window, starts the simulation

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class MainWindow extends Application 
{
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 1000;
	private static final BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Button btn = new Button();
			btn.setText("Start Game");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	            	Scene scene2 = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
	            	primaryStage.setTitle("AstroCode");
	    			primaryStage.setScene(scene2);
	    			primaryStage.show();
	            	GameLauncher g = new GameLauncher();
	    			g.startGame();
	            }
	        });
	        
	        Button btn2 = new Button();
			btn2.setText("Exit");
			btn2.setOnAction(new EventHandler<ActionEvent>() {
				 
	            @Override
	            public void handle(ActionEvent event) {
	            	System.exit(0);
	            }
	        });
	        
	        Pane root = new Pane();
	        btn.setLayoutX(105);
	        btn.setLayoutY(105);
	        root.getChildren().add(btn);
	        
	        btn2.setLayoutX(125);
	        btn2.setLayoutY(145);
	        root.getChildren().add(btn2);

	        Scene scene = new Scene(root, 300, 300);
	        primaryStage.setTitle("AstroCode");
			primaryStage.setScene(scene);
			primaryStage.show();	
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
	public static BorderPane getBorderPane()
	{
		return root;
	}
	public static int getWidth()
	{
		return WINDOW_WIDTH;
	}
	public static int getHeight()
	{
		return WINDOW_HEIGHT;
	}
}