package application;

import javafx.scene.Parent;
import level.InputProcessor;
import level.Level;
import level.Spaceship;

public class GameLauncher extends Parent
{
    private Spaceship ship = Spaceship.getInstance();
    private Level curLevel;
    private InputProcessor input;

    public GameLauncher()
    {
    	super();
    }

    public void startGame()
    {
    	System.out.println("get ready");
    	input = new InputProcessor();
    	
    	curLevel = new Level();
    	input.setAnswer(curLevel);
    	
    	curLevel.displayElements();
    	curLevel.advanceQuestion();
    	curLevel.displayElements();
    	ship.display();
    }
    
    public void gameOver()
    {
    	System.out.println("Game Over");
    }
    
    public void restart()
    {
    	System.out.println("Game will Restart");
        
        //this function should restart the game by running startGame()
    }
    
    public boolean testConnection()
    {
        return true;
    }
}
