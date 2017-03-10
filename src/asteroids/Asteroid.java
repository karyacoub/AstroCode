package asteroids;

import java.awt.Point;
import java.util.Random;
import javafx.scene.image.Image;

public abstract class Asteroid 
{	
	private final int NUM_SPRITES = 3;
	
	protected double size;
	protected Image sprite;
	protected Point position;
	
	int randInt(int lowerBound, int upperBound)
	{
		Random rand = new Random();
		return rand.nextInt(upperBound) + lowerBound;
	}
	
	// chooses one of the sprites in the assets folder
	protected Image chooseSprite()
	{
		int rand = randInt(1, NUM_SPRITES);
		
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
	
	// getters
	public double getSize()
	{
		return size;
	}
	public Image getSprite()
	{
		return sprite;
	}
	public Point getPos()
	{
		return position;
	}
}
