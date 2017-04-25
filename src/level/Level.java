package level;

import application.GameLauncher;
import application.MainWindow;
import asteroids.AsteroidField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
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
    	return questionBank.getCurQuestion().getAnswer().toLowerCase();
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
    
    public AsteroidField getAsteroidField()
    {
    	return asteroidField;
    }
    
    public QuestionTimer getQuestionTimer()
    {
    	return timer;
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
    	try
    	{
	    	asteroidField.removeAsteroids();
	    	questionBank.getCurQuestion().removeText();
	    	timer.removeTimer();
    	}
    	catch(Exception e)
    	{
    		return;
    	}
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
    		// display game over screen
    		// advance question, makes screen blank
    		GameLauncher.getLevel().removeElements();
    		
    		// add text that says "You win!!" to the screen
    		Text text = new Text();
    		text.setText("Game over!");
    		text.setFont(Font.font("Ariel", 40));	
    		MainWindow.getBorderPane().setCenter(text);
    		
    		// let it linger for a bit
    		Timeline t = new Timeline(new KeyFrame(Duration.millis(5000), ev -> {}));
    		t.setCycleCount(1);
    		
    		// when timer is done running, remove text, display next question
    		t.setOnFinished(new EventHandler<ActionEvent>()
    				{
    					@Override
    					public void handle(ActionEvent e)
    					{
    						System.exit(0);
    					}
    				});
    		t.play();
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
