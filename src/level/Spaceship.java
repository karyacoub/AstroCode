package level;

import asteroids.Asteroid;

public class Spaceship
{
    private static final Spaceship INSTANCE = new Spaceship();
    private int Hp;

    /**
     * Constructor for objects of class Spaceship
     */
    private Spaceship()
    {
     Hp = 100;
        
    }

    /**
     * Destroys Asteroid called when correct answer is given.
     * 
     * @param  Asteroid 
     * @return     void
     */
    public void shoot(Asteroid a)
    {
      
    }
    
    /**
     * If a correct asnwer isn't given in time the spaceship will crash into the asteroid and decrease it's hp
     * 
     * @param  Asteroid 
     * @return     void
     */
    public void crash (Asteroid a)
    {
        decreaseHp();
        System.out.println("Ships hull has been breached");
    }
    /**
     * decreases the hp of the ship - for now by 25 later will be based on other factors (size of asteroid etc.)
     * 
     * @param  none
     * @return     void
     */
    public void decreaseHp()
    {
      Hp = Hp - 25;
      System.out.println("Damage taken");
    }
    /**
     * increases the hp of the ship - for now by 25 later will be based on other factors(power ups etc.)
     * 
     * @param  none 
     * @return     void
     */
    public void replenishHp()
    {
     this.Hp = Hp + 25;
    }
    public int checkHp()
    {
        return this.Hp;
    }
    
    public static synchronized Spaceship getInstance(){
            return INSTANCE; 
    }
    
}
