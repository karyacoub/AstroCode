package asteroids;

import questions.QuestionBank;

public class AsteroidFactory 
{
	public Asteroid getAsteroid(String asteroidType)
	{
		asteroidType = asteroidType.toLowerCase();
		
		if(!asteroidType.equals("big") && !asteroidType.equals("medium") && !asteroidType.equals("small"))
		{
			throw new IllegalArgumentException("Recieved asteroid type does not exist");
		}
		else if(asteroidType.equals("big"))
		{
			return new BigAsteroid();
		}
		else if(asteroidType.equals("medium"))
		{
			return new MediumAsteroid();
		}
		
		return new SmallAsteroid();
	}
}
