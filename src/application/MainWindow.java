/* Main.hava */
// initializes main window, starts the simulation

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainWindow extends Application 
{
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 720;
	private static final BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			GameLauncher g = new GameLauncher();
			g.startGame();
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