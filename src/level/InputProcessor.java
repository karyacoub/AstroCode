package level;

import application.MainWindow;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class InputProcessor
{
    private TextField input;
    private String answer;

    /**
     * Constructor for objects of class inputProcessor
     */
    public InputProcessor()
    {
    	input = new TextField();
    	input.setPromptText("Type in answer here...");
    	input.setPrefHeight(150);
    	input.setFont(Font.font("Courier New", 45));

    	MainWindow.getBorderPane().setBottom(input);
    }
    
    public String setAnswer(Level level)
    {
    	answer = level.getCurAnswer();
    	return answer;
    }

    public String setInput()
    {
        // put your code here
        return "dummy input"; //getInput();
    }
    
    public String getInput()
    {
       return "dummy input"; //s.nextLine();  
    }
    
    public boolean isAnswer()
    {
        return true;
    }
}
