package level;

import asteroids.AsteroidField;
import questions.QuestionBank;

public class Level
{
    //private QuestionBank questionBank;
    private AsteroidField asteroidField;
    private QuestionBank questionBank;
    private int counter;
    private int curLevel;
    


    public Level(AsteroidField af, QuestionBank q)
    {
        questionBank = q;
        asteroidField = af;
        this.counter = 0;
        this.curLevel = 1;
    }


    public void showCurQuestion()
    {
        System.out.println("This is a test question");
    }
    
     
    public void advanceQuestion()
    {
      System.out.println("this is a dummy next question");
     }
    
   
    
    public void advanceLevel()
    {
         curLevel++;
         System.out.println("Current Level: " + this.curLevel);
         this.counter = 0;
         System.out.println("Current answers correct: " + this.counter);
     
    }
}
