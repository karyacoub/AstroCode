package asteroids;

public class SmallAsteroid extends Asteroid
{
	private static final int MIN_SIZE = 130;
	private static final int MAX_SIZE = 159;
	
	// constructor to be used if connection to nasa servers could not be established
	public SmallAsteroid()
	{
		size = randInt(MIN_SIZE, MAX_SIZE);
		sprite = chooseSprite();
		position = choosePosition();
		isDestroyed = false;
	}
}
