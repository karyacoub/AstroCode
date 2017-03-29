package asteroids;

import java.awt.Point;
import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import application.MainWindow;

public abstract class Asteroid 
{	
	private final static int NUM_ASTEROIDS_ON_SCREEN = 3;
	private final static int MIN_ROTATION_DURATION = 50000;
	private final static int MAX_ROTATION_DURATION = 20000;
	
	private static int filledPositions = 0;
	
	protected double size;
	protected Image sprite;
	protected Point position;
	protected String possibleAnswer;
	
	protected int randInt(int lowerBound, int upperBound)
	{
		Random rand = new Random();
		return rand.nextInt(upperBound) + lowerBound;
	}
	
	// chooses one of the sprites in the assets folder
	protected Image chooseSprite()
	{
		int rand = randInt(1, NUM_ASTEROIDS_ON_SCREEN);
		
		if(rand == 1)
		{
			return new Image("file:assets/asteroid_1.png", size, size, false, false);
		}
		else if(rand == 2)
		{
			return new Image("file:assets/asteroid_2.png", size, size, false, false);
		}
		return new Image("file:assets/asteroid_3.png", size, size, false, false);
	}
	protected Point choosePosition()
	{
		filledPositions++;
		
		if(filledPositions == 1) // leftmost asteroid
		{	
			return new Point(100, (MainWindow.getHeight() / 2) - (int)(size));
		}
		else if(filledPositions == 2) // middle asteroid
		{
			return new Point((MainWindow.getWidth() / 2), (MainWindow.getHeight() / 2)  - (int)(size));
		}
		//rightmost asteroid
		return new Point((MainWindow.getWidth() - 100) - (int)(size), (MainWindow.getHeight() / 2)  - (int)(size));
	}
	
	// display asteroid on main window
	protected void displayAsteroid()
	{
		ImageView iv = new ImageView(sprite);
		iv.setX(position.getX());
		iv.setY(position.getY());
		MainWindow.getBorderPane().getChildren().add(iv);
		
		int duration = randInt(MIN_ROTATION_DURATION, MAX_ROTATION_DURATION);
		
		RotateTransition rt = new RotateTransition(Duration.millis(duration), iv);
		rt.setByAngle(1080);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.play();
	}
	
	// getters
	public double getSize()
	{
		return size;
	}
	public Image getSprite()
	{
		return sprite;
	}
}
