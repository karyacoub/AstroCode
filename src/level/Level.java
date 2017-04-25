package level;

import java.awt.Point;

import application.GameLauncher;
import application.MainWindow;
import asteroids.AsteroidField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private int curLives;
    
    private static final Point FIRST_LIVES_POSITION = new Point (MainWindow.getWidth()/2 + 400, MainWindow.getHeight() - 260);
    private static final Point SECOND_LIVES_POSITION = new Point (MainWindow.getWidth()/2 + 430, MainWindow.getHeight() - 260);
    private static final Point THIRD_LIVES_POSITION = new Point (MainWindow.getWidth()/2 + 460, MainWindow.getHeight() - 260);

    private ImageView one_death = new ImageView(new Image("file:assets/temp_ship_death.png", 30, 30, false, false)); 
	private ImageView first_life = new ImageView(new Image("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
	private ImageView second_life = new ImageView(new Image ("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
	private ImageView third_life = new ImageView(new Image ("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
    
    public Level()
    {
        questionBank = new QuestionBank();
        asteroidField = new AsteroidField(questionBank);
        timer = new QuestionTimer(SECONDS_PER_QUESTION);
        this.counter = 0;
        this.curLevel = 1;
        this.curQuestion = 1;
        this.curAttempt = 1;
        this.curLives = 3;
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
    
    public int getCurLives(){
    	return curLives;
    }
    
    public QuestionTimer getQuestionTimer()
    {
    	return timer;
    }
    
    public void display_Lives(int curLives, int curAttempts)
    {
    	if(curLives == 3){
    		first_life.setX(FIRST_LIVES_POSITION.getX());
        	first_life.setY(FIRST_LIVES_POSITION.getY());
        	
        	second_life.setX(SECOND_LIVES_POSITION.getX());
        	second_life.setY(SECOND_LIVES_POSITION.getY());
        	
        	third_life.setX(THIRD_LIVES_POSITION.getX());
        	third_life.setY(THIRD_LIVES_POSITION.getY());
        	
        	MainWindow.getBorderPane().getChildren().add(first_life);
        	MainWindow.getBorderPane().getChildren().add(second_life);
        	MainWindow.getBorderPane().getChildren().add(third_life);

    	}
    	else if(curLives == 2 ){
    		if(curAttempt == 2){
    		MainWindow.getBorderPane().getChildren().remove(third_life);
    		third_life = one_death;
    		third_life.setX(THIRD_LIVES_POSITION.getX());
        	third_life.setY(THIRD_LIVES_POSITION.getY());
        	MainWindow.getBorderPane().getChildren().add(third_life);
        	Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
    		t.setCycleCount(1);
    		
    		t.setOnFinished(new EventHandler<ActionEvent>()
    				{
    					@Override
    					public void handle(ActionEvent e)
    					{
    						MainWindow.getBorderPane().getChildren().remove(third_life);
    						third_life = new ImageView(new Image ("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
    					}
    				});
    		t.play();}
    		else
    		{
    			MainWindow.getBorderPane().getChildren().remove(third_life);
    		}
        	
    	}
    	else if(curLives == 1)
    	{
    		if(curAttempts == 2){
    		MainWindow.getBorderPane().getChildren().remove(second_life);
    		second_life = one_death;
    		second_life.setX(SECOND_LIVES_POSITION.getX());
        	second_life.setY(SECOND_LIVES_POSITION.getY());
        	MainWindow.getBorderPane().getChildren().add(second_life);
        	Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
    		t.setCycleCount(1);
    		
    		t.setOnFinished(new EventHandler<ActionEvent>()
    				{
    					@Override
    					public void handle(ActionEvent e)
    					{
    						MainWindow.getBorderPane().getChildren().remove(second_life);
    						second_life = new ImageView(new Image ("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
    					}
    				});
    		t.play();
    		}
    		else
    		{
				MainWindow.getBorderPane().getChildren().remove(second_life);

    		}
    	}
    	else{
    		MainWindow.getBorderPane().getChildren().remove(first_life);
    		first_life = one_death;
    		first_life.setX(FIRST_LIVES_POSITION.getX());
        	first_life.setY(FIRST_LIVES_POSITION.getY());
        	MainWindow.getBorderPane().getChildren().add(first_life);
        	Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
    		t.setCycleCount(1);
    		
    		t.setOnFinished(new EventHandler<ActionEvent>()
    				{
    					@Override
    					public void handle(ActionEvent e)
    					{
    						MainWindow.getBorderPane().getChildren().remove(first_life);
    						first_life = new ImageView(new Image ("file:assets/temp_ship_one_life copy.png", 30, 30, false, false));
    					}
    				});
    		t.play();    		    	
    		
    		
    		Text text = new Text();
    		text.setText("Game over!");
    		text.setFont(Font.font("Ariel", 40));	
    		MainWindow.getBorderPane().setCenter(text);
    		
    		t = new Timeline(new KeyFrame(Duration.millis(5000), ev -> {}));
    		t.setCycleCount(1);
    		
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
    }

    // displays question and asteroids
    public void displayElements()
    {

    	
    	asteroidField.display();
    	questionBank.displayCurQuestion();
    	
    	timer.display();
    	timer.startTimer();
    	this.display_Lives(curLives, curAttempt);
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

	public void lose_Life() {
		if(this.curLives > 0)
		this.curLives--;
		else{
			}
	}

	
	
}
