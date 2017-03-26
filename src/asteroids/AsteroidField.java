package asteroids;

import java.util.Random;

public class AsteroidField 
{
	private final int NUM_TYPES_OF_ASTEROIDS = 3;
	
	private AsteroidFactory factory = new AsteroidFactory();
	private Asteroid curAsteroids[];
	
	public AsteroidField()
	{
		curAsteroids = initCurAsteroids();
	}
	
	public void display()
	{
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			curAsteroids[i].displayAsteroid();
		}
	}
	
	public void printAsteroidInfo() // for debugging //
	{
		System.out.println("** CURRENT ASTEROID INFO **");
		
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			System.out.println("Asteroid " + (i+1) + ":");
			System.out.println("\t SIZE: " + curAsteroids[i].getSize());
			System.out.println("\t SPRITE: " + curAsteroids[i].getSprite());
		}
	}
	public Asteroid[] getCurAsteroids()
	{
		return curAsteroids;
	}
	
	private Asteroid[] initCurAsteroids()
	{
		Asteroid asteroids[] = new Asteroid[NUM_TYPES_OF_ASTEROIDS];
		
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			int asteroidChoice = chooseRandomAsteroid();
			
			if(asteroidChoice == 1) // big asteroid
			{
				asteroids[i] = factory.getAsteroid("big");
			}
			else if(asteroidChoice == 2) // medium asteroid
			{
				asteroids[i] = factory.getAsteroid("medium");
			}
			else // small asteroid
			{
				asteroids[i] = factory.getAsteroid("small");
			}
		}
		
		return asteroids;
	}
	private int chooseRandomAsteroid()
	{
		return randInt(1, NUM_TYPES_OF_ASTEROIDS);
	}
	private int randInt(int lowerBound, int upperBound)
	{
		Random rand = new Random();
		return rand.nextInt(upperBound) + lowerBound;
	}
}
