package level;

import application.GameLauncher;
import application.MainWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class InputProcessor
{
    private TextField textBox;
    private String input;
    private String answer;

    /**
     * Constructor for objects of class inputProcessor
     */
    public InputProcessor()
    {
    	textBox = new TextField();
    	textBox.setPromptText("Type in answer here...");
    	textBox.setPrefHeight(150);
    	textBox.setFont(Font.font("Courier New", 45));
    	
    	textBox.setOnKeyPressed(new EventHandler<KeyEvent>()
    			{
    				@Override
    				public void handle(KeyEvent e)
    				{
    					if(e.getCode() == KeyCode.ENTER)
    					{
    						setInput();
    						textBox.clear();
    						
    						if(isAnswer()) // if answer is correct
    						{
    							GameLauncher.getLevel().advanceQuestion();
    							GameLauncher.startGame();
    						}
    						else // if answer is incorrect
    						{
    							// if there is still some attempts left, display number of attempts left and play appropriate animation
    							if(GameLauncher.getLevel().getCurAttempt() < GameLauncher.getLevel().getMaxAttempts())
    							{
    								GameLauncher.getLevel().nextAttempt();
    								GameLauncher.getShip().shake();
    								displayNumAttempts();
    							}
    							// if user runs out of attempts, show incorrect answer prompt, advance question
    							else
    							{
    								displayOutOfAttempts();
    							}
    						}
    					}
    				}
    			}
    	);

    	MainWindow.getBorderPane().setBottom(textBox);
    }

    public String setAnswer(Level level)
    {
    	answer = level.getCurAnswer();
    	return answer;
    }
   
    public String setInput()
    {
        input = textBox.getText().toLowerCase();
        
        return input;
    }
    
    public String getInput()
    {
       return input;
    }
    
    public boolean isAnswer()
    {
        return input.equals(answer);
    }
    
    private void displayNumAttempts()
    {
    	int attemptsLeft = 1 + GameLauncher.getLevel().getMaxAttempts() - GameLauncher.getLevel().getCurAttempt();
		
		// display number of attempts on screen
		Text text = new Text();
		text.setText("Attempts left: " + attemptsLeft);
		text.setFont(Font.font("Ariel", 25));	
		text.setX(MainWindow.getWidth() - 210);
		text.setY(MainWindow.getHeight() - 210);
		MainWindow.getBorderPane().getChildren().add(text);
		
		// let it linger for a bit
		Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
		t.setCycleCount(1);
		
		// when timer is done running, remove text, display next question
		t.setOnFinished(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						MainWindow.getBorderPane().getChildren().remove(text);
					}
				});
		t.play();
    }
    
    private void displayOutOfAttempts()
    {
    	// advance question, makes screen blank
		GameLauncher.getLevel().advanceQuestion();
		
		// add text that says "Sorry, you're out of attempts!" to the screen
		Text text = new Text();
		text.setText("Sorry, you're out of attempts!");
		text.setFont(Font.font("Ariel", 40));	
		MainWindow.getBorderPane().setCenter(text);
		
		// let it linger for a bit
		Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
		t.setCycleCount(1);
		
		// when timer is done running, remove text, display next question
		t.setOnFinished(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						MainWindow.getBorderPane().getChildren().remove(text);
						GameLauncher.startGame();
					}
				});
		t.play();
    }
}
