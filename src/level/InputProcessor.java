package level;

public class InputProcessor
{
    private String input;
    private String answer;

    /**
     * Constructor for objects of class inputProcessor
     */
    public InputProcessor()
    {
    	
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
