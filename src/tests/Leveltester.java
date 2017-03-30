package tests;

import level.Level;

public class Leveltester
{
    public static void main (String args[])
    {
        
        Level a = new Level();
        
        System.out.println("Successfully displayed current question"); a.showCurQuestion();
        
        System.out.println("successfully displayed next question"); a.advanceQuestion();
        
        System.out.println("Attempt to advance to next level");
        a.advanceLevel();
        
        
        
    }
}
