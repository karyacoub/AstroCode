package tests;

import level.Level;
import level.GameLauncher;
import level.Spaceship;
import questions.QuestionBank;
import asteroids.AsteroidField;

public class GameLauncherTester
{
   public static void main(String args[])
   {
       Level l = new Level(new AsteroidField(), new QuestionBank());
       AsteroidField a = new AsteroidField();
       Spaceship ship = Spaceship.getInstance();
       
       GameLauncher g = new GameLauncher(a, l, ship);
       
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
