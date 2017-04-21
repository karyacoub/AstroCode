package level;

import application.MainWindow;
import asteroids.AsteroidField;
import questions.QuestionBank;

public class Level
{
    private AsteroidField asteroidField;
    private QuestionBank questionBank;
    private int counter;
    private int curQuestion;
    private int curLevel;
    
    public Level()
    {
        questionBank = new QuestionBank();
        asteroidField = new AsteroidField(questionBank);
        this.counter = 0;
        this.curLevel = 1;
        this.curQuestion = 1;
    }
    
    public String getCurAnswer()
    {
    	return questionBank.getCurQuestion().getAnswer();
    }

    // displays question and asteroids
    public void displayElements()
    {
    	asteroidField.display();
    	questionBank.displayCurQuestion();
    }
    
    // removes asteroids + current question from window
    public void removeElements()
    {
    	MainWindow.getBorderPane().getChildren().remove(8);
    	MainWindow.getBorderPane().getChildren().remove(7);
    	MainWindow.getBorderPane().getChildren().remove(6);
    	MainWindow.getBorderPane().getChildren().remove(5);
    	MainWindow.getBorderPane().getChildren().remove(4);
    	MainWindow.getBorderPane().getChildren().remove(3);
    	MainWindow.getBorderPane().getChildren().remove(2);
    }
    
    public void advanceQuestion()
    {
    	// remove the question + asteroids currently on the window
    	removeElements();
    	
    	// grab the next question
    	questionBank.nextQuestion();
    	
    	if(questionBank.getCurQuestion() == null)
    	{
    		System.out.println("Game over");  //TEMPORARY
    		System.exit(0);
    	}
    	
    	//create new asteroid field
    	asteroidField = new AsteroidField(questionBank);
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
