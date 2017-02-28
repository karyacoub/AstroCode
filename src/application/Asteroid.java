/** Asteroid.java **/
// stores asteroid data to be used in conjunction with AsteroidField class

package application;

import java.awt.Point;
import java.util.Random;
import javafx.scene.image.Image;

public class Asteroid
{
	private static final int MIN_SIZE = 50;
	private static final int MAX_SIZE = 200;
	private static final int MIN_SPEED = 1;
	private static final int MAX_SPEED = 5; 	// TEMPORARY //
	
	private Image image;
	private double size;
	private double speed;
	private Point position;
	
	// constructor to be used if no Internet connection is found
	public Asteroid(double size, double speed)
	{
		this.size = size;
		this.speed = speed;
		
		int windowWidth = Main.getWidth();
		int startingXPosition = randInt(0, windowWidth);
		
		position = new Point(startingXPosition, (int)(-size));
		
		image = new Image("file:assets/temp_asteroid.png", size, size, false, false);
	}
	
	public Asteroid()
	{
		size = randInt(MIN_SIZE, MAX_SIZE);
		speed = randInt(MIN_SPEED, MAX_SPEED);

		int windowWidth = Main.getWidth();
		int startingXPosition = randInt(0, windowWidth);
		
		position = new Point(startingXPosition, (int)(-size));
		
		image = new Image("file:assets/temp_asteroid.png", size, size, false, false);
	}
	
	
	public void moveTowardsShip()
	{
		
	}
	
	private int randInt(int lowerBound, int upperBound)
	{
		Random rand = new Random();
		return rand.nextInt(upperBound) + lowerBound;
	}
	
	public int getX()
	{
		return (int) position.getX();
	}
	public int getY()
	{
		return (int) position.getY();
	}
	public Image getImage()
	{
		return image;
	}
	public double getSize()
	{
		return size;
	}
	public double getSpeed()
	{
		return speed;
	}
}