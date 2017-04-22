package level;

import application.MainWindow;
import asteroids.AsteroidField;
import questions.QuestionBank;

public class Level
{
	private final int SECONDS_PER_QUESTION = 20;
	private final int MAX_ATTEMPTS = 2;
	
    private AsteroidField asteroidField;
    private QuestionBank questionBank;
    private QuestionTimer timer;
    private int counter;
    private int curQuestion;
    private int curLevel;
    private int curAttempt;
    
    public Level()
    {
        questionBank = new QuestionBank();
        asteroidField = new AsteroidField(questionBank);
        timer = new QuestionTimer(SECONDS_PER_QUESTION);
        this.counter = 0;
        this.curLevel = 1;
        this.curQuestion = 1;
        this.curAttempt = 1;
    }
    
    public String getCurAnswer()
    {
    	return questionBank.getCurQuestion().getAnswer();
    }
    
    public int getCurAttempt()
    {
    	return curAttempt;
    }
    
    public void nextAttempt()
    {
    	curAttempt++;
    }
    
    public int getMaxAttempts()
    {
    	return MAX_ATTEMPTS;
    }

    // displays question and asteroids
    public void displayElements()
    {
    	asteroidField.display();
    	questionBank.displayCurQuestion();
    	timer.display();
    	timer.startTimer();
    }
    
    // removes asteroids, current question, and timer from window
    public void removeElements()
    {
    	MainWindow.getBorderPane().getChildren().remove(8);
    	MainWindow.getBorderPane().getChildren().remove(7);
    	MainWindow.getBorderPane().getChildren().remove(6);
    	MainWindow.getBorderPane().getChildren().remove(5);
    	MainWindow.getBorderPane().getChildren().remove(4);
    	MainWindow.getBorderPane().getChildren().remove(3);
    	MainWindow.getBorderPane().getChildren().remove(2);
    	timer.removeTimer();
    }
    
    public void advanceQuestion()
    {
    	// reset timer
    	timer.stopTimer();
    	timer.resetTimer();
    	
    	// reset current attempt
    	curAttempt = 1;
    	
    	curQuestion++;
    	
    	// if 5 questions successfully completed, advance level
    	if((curQuestion - 1)%5 == 0)
    	{
    		advanceLevel();
    	}
    	
    	// remove the question + asteroids currently on the window
    	removeElements();
    	
    	// grab the next question
    	questionBank.nextQuestion();
    	
    	if(questionBank.getCurQuestion() == null)
    	{
    		System.out.println("NO MORE QUESTIONS LEFT");  //TEMPORARY
    		//System.exit(0);
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
