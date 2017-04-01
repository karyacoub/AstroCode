package level;

import application.MainWindow;
import asteroids.Asteroid;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.awt.Point;

public class Spaceship
{
    private static final Spaceship INSTANCE = new Spaceship();
    private static final double SIZE = 80;
    private static final int ANIMATION_DURATION = 1000;
    private static final Point OFF_SCREEN_POSITION = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() + 200);
    private static final Point ON_SCREEN_POSITION = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() - 200);
    
    private int hp;
    private ImageView sprite;

    private Spaceship()
    {
    	hp = 100;
    	sprite = new ImageView(new Image("file:assets/temp_ship.png", SIZE, SIZE, false, false));
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
     * If a correct answer isn't given in time the spaceship will crash into the asteroid and decrease it's hp
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
	      hp = hp - 25;
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
    	hp = hp + 25;
    }
    public int checkHp()
    {
        return hp;
    }
    
    public static synchronized Spaceship getInstance()
    {
    	// add ship to main window
    	INSTANCE.sprite.setX(OFF_SCREEN_POSITION.getX());
    	INSTANCE.sprite.setY(OFF_SCREEN_POSITION.getY());
    	MainWindow.getBorderPane().getChildren().add(INSTANCE.sprite);
    	
        return INSTANCE; 
    }
    
    public void flyOnScreen()
    {	
    	// allow ship to fly up from under window
    	Path path = new Path();
    	path.getElements().add(new MoveTo(sprite.getX(), sprite.getY()));
    	path.getElements().add(new LineTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY()));
    	PathTransition pathTransition = new PathTransition();
    	pathTransition.setNode(sprite);
    	pathTransition.setPath(path);
    	pathTransition.setDuration(Duration.millis(ANIMATION_DURATION));
    	
    	pathTransition.play();
    }
    
    public void flyOffScreen()
    {
    	
    }
    
}
