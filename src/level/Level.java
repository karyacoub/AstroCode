package level;

import application.MainWindow;
import asteroids.AsteroidField;
import questions.QuestionBank;

public class Level
{
    private AsteroidField asteroidField;
    private QuestionBank questionBank;
    private int counter;
    private int curLevel;
    
    public Level()
    {
        questionBank = new QuestionBank();
        asteroidField = new AsteroidField();
        this.counter = 0;
        this.curLevel = 1;
    }

    // displays question and asteroids
    public void displayElements()
    {
    	asteroidField.display();
    	questionBank.displayCurQuestion();
    }
    
    public void advanceQuestion()
    {
    	// remove the question currently on the window
    	MainWindow.getBorderPane().getChildren().remove(3);
    	
    	// grab the next question
    	questionBank.nextQuestion();
    }
    
    public void showCurQuestion()
    {
    	System.out.println(questionBank.getCurQuestion().getQuestion());
    }
    
    public void advanceLevel()
    {
         curLevel++;
         System.out.println("Current Level: " + this.curLevel);
         this.counter = 0;
         System.out.println("Current answers correct: " + this.counter);
     
    }
}
