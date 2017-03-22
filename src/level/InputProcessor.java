package level;

import java.util.Scanner;
/**
 * Write a description of class inputProcessor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputProcessor
{
    private String input;
    private String answer;
    private Scanner s;

    /**
     * Constructor for objects of class inputProcessor
     */
    public InputProcessor()
    {
      s = new Scanner(System.in);
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String setInput()
    {
        // put your code here
        return "dummy input"; //getInput();
    }
    public String setAnswer()
    {
       return "test answer"; 
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
