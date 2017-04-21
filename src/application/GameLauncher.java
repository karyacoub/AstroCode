package application;

import javafx.scene.Parent;
import level.InputProcessor;
import level.Level;
import level.Spaceship;

public class GameLauncher extends Parent 
{
    private static Spaceship ship = Spaceship.getInstance();
    private static Level curLevel = new Level();
    private static InputProcessor input;

    public GameLauncher()
    {
    	super();
    }

    public static void startGame()
    {	
    	input = new InputProcessor();
    	input.setAnswer(curLevel);
    	
    	ship.flyOnScreen();
    	
    	curLevel.displayElements();
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
    
    public static Level getLevel()
    {
    	return curLevel;
    }
    
    public static Spaceship getShip()
    {
    	return ship;
    }
    
    public boolean testConnection()
    {
        return true;
    }
}
