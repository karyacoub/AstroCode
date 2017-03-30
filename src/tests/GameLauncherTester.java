package tests;

import level.Level;
import application.GameLauncher;
import asteroids.AsteroidField;

public class GameLauncherTester
{
   public static void main(String args[])
   {
       Level l = new Level();
       AsteroidField a = new AsteroidField();
       
       GameLauncher g = new GameLauncher();
       
       System.out.println("testing startGame");
       g.startGame();
       
       System.out.println("testing gameOver");
       g.gameOver();
       
       System.out.println("testing restart");
       g.restart();
       
       System.out.println("testing testConnection");
       if(g.testConnection())
       System.out.println("connection success");
    }
}
