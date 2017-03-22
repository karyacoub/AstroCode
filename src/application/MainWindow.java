/* Main.hava */
// initializes main window, starts the simulation

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import level.GameLauncher;


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
			Scene tempScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			primaryStage.setScene(tempScene);
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