package asteroids;

public class SmallAsteroid extends Asteroid
{
	private static final int MIN_SIZE = 150;
	private static final int MAX_SIZE = 199;
	
	// constructor to be used if connection to nasa servers could not be established
	public SmallAsteroid()
	{
		size = randInt(MIN_SIZE, MAX_SIZE);
		sprite = chooseSprite();
	}
}
