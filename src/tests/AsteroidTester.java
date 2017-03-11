package tests;
	
import asteroids.AsteroidField;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class AsteroidTester extends Application 
{
	// apparently javafx stops me from running the program without all this stuff
	// by giving me a runtime exception, so i can't test the asteroid classes 
	// without having it all here
	
	@Override
	public void start(Stage primaryStage)
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
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
		//launch(args);
		AsteroidField asteroidField = new AsteroidField();
		asteroidField.printAsteroidInfo();
		System.exit(0);
	}
}
