package asteroids;

public class BigAsteroid extends Asteroid
{
	private static final int MIN_SIZE = 70;
	private static final int MAX_SIZE = 99;
	
	// constructor to be used if connection to nasa servers could not be established
	public BigAsteroid()
	{
		size = randInt(MIN_SIZE, MAX_SIZE);
		sprite = chooseSprite();
		position = choosePosition();
		isDestroyed = false;
	}
}
