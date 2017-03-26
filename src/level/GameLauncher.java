package level;

import asteroids.AsteroidField;
import javafx.scene.Parent; 

public class GameLauncher extends Parent
{
    private AsteroidField asteroidField = new AsteroidField();
    private Spaceship ship = Spaceship.getInstance();
    private Level curLevel;

    public GameLauncher()
    {
    	super();
    }

    public void startGame()
    {
    	System.out.println("get ready");
    	asteroidField.display();
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
