package level;

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
    						System.out.println(input);
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
        input = textBox.getText();
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
