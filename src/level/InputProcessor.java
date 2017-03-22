package level;

import java.util.Scanner;

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
