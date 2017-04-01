package asteroids;

public class MediumAsteroid extends Asteroid
{
	private static final int MIN_SIZE = 100;
	private static final int MAX_SIZE = 129;
	
	// constructor to be used if connection to nasa servers could not be established
	public MediumAsteroid()
	{
		size = randInt(MIN_SIZE, MAX_SIZE);
		sprite = chooseSprite();
		position = choosePosition();
		isDestroyed = false;
	}
}
