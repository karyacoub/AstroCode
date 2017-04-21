package level;

import application.GameLauncher;
import application.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

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
    							if(GameLauncher.getLevel().getCurAttempt() < GameLauncher.getLevel().getMaxAttempts())
    							{
    								GameLauncher.getLevel().nextAttempt();
    							}
    							else
    							{
    								System.out.println("GAME OVER");
    								System.exit(0);
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
}
