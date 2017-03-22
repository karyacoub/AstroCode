package level;

import asteroids.AsteroidField; 

public class GameLauncher
{
    AsteroidField asteroidField;
    Level curLevel;
    Spaceship ship;

    /**
     * Constructor for GameLauncher
     */
    public GameLauncher(/*AsteroidField a,*/ Level l /*, Spaceship s*/)
    {
        //asteroidField = a;
        curLevel = l;
        //ship = s;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void startGame()
    {
      System.out.println("get ready"); 
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
