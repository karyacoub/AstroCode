package asteroids;

import java.util.Random;

import application.MainWindow;
import questions.QuestionBank;

public class AsteroidField 
{
	private final int NUM_TYPES_OF_ASTEROIDS = 3;
	
	private AsteroidFactory factory = new AsteroidFactory();
	private Asteroid curAsteroids[];
	
	public AsteroidField(QuestionBank question)
	{
		initCurAsteroids(question);
	}
	
	// display all current asteroids on screen
	public void display()
	{
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			curAsteroids[i].displayAsteroid();
		}
	}
	
	public void printAsteroidInfo() // for debugging
	{
		System.out.println("** CURRENT ASTEROID INFO **");
		
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			System.out.println("Asteroid " + (i+1) + ":");
			System.out.println("\t SIZE: " + curAsteroids[i].getSize());
			System.out.println("\t SPRITE: " + curAsteroids[i].getSprite());
			System.out.println("\t POSSIBLE ANSWER: " + curAsteroids[i].getPossibleAnswer());
		}
	}
	
	// returns asteroid containing the correct answer
	public Asteroid getAsteroidWithAnswer(String answer)
	{
		Asteroid a = null;
		
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			if(curAsteroids[i].getPossibleAnswer().equals(answer))
			{
				a = curAsteroids[i];
			}
		}
		
		return a;
	}
	
	public void removeAsteroids()
	{
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			MainWindow.getBorderPane().getChildren().remove(curAsteroids[i].getSprite());
			curAsteroids[i].removeText();
		}
	}
	
	public Asteroid[] getCurAsteroids()
	{
		return curAsteroids;
	}
	
	private Asteroid[] initCurAsteroids(QuestionBank question)
	{
		curAsteroids = new Asteroid[NUM_TYPES_OF_ASTEROIDS];
		
		for(int i = 0; i < NUM_TYPES_OF_ASTEROIDS; i++)
		{
			int asteroidChoice = chooseRandomAsteroid();
			
			if(asteroidChoice == 1) // big asteroid
			{
				curAsteroids[i] = factory.getAsteroid("big");
			}
			else if(asteroidChoice == 2) // medium asteroid
			{
				curAsteroids[i] = factory.getAsteroid("medium");
			}
			else // small asteroid
			{
				curAsteroids[i] = factory.getAsteroid("small");
			}
		}
		
		// set possible answer for each asteroid
		setPossibleAnswers(question);
		
		return curAsteroids;
	}
	private int chooseRandomAsteroid()
	{
		return randInt(1, NUM_TYPES_OF_ASTEROIDS);
	}
	private void setPossibleAnswers(QuestionBank question)
	{
		String possibleAnswer1 = question.getCurQuestion().getPossibleAnswer1();
		String possibleAnswer2 = question.getCurQuestion().getPossibleAnswer2();
		String possibleAnswer3 = question.getCurQuestion().getPossibleAnswer3();
		
		try
		{
			curAsteroids[0].setPossibleAnswer(possibleAnswer1);
			curAsteroids[1].setPossibleAnswer(possibleAnswer2);
			curAsteroids[2].setPossibleAnswer(possibleAnswer3);
		} catch(NullPointerException e)
		{
			System.out.println("NullPointerException: Asteroids have not been initialized");
			System.exit(-1);
		}
	}
	private int randInt(int lowerBound, int upperBound)
	{
		Random rand = new Random();
		return rand.nextInt(upperBound) + lowerBound;
	}
}
