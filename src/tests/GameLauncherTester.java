package tests;

import level.Level;
import level.GameLauncher;

public class GameLauncherTester
{
   public static void main(String args[])
   {
       Level l = new Level();
       
       GameLauncher g = new GameLauncher(l);
       
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
