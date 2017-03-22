
/**
 * Write a description of class GameLauncherTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameLauncherTester
{
   public static void main(String args[])
   {
       
       Level l = new Level();
       
       gameLauncher g = new gameLauncher(l);
       
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
