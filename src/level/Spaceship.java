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
    private static final int FLY_UP_ANIMATION_DURATION = 1000;
    private static final int SHAKE_ANIMATION_DURATION = 80;
    private static final Point OFF_SCREEN_POSITION = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() + 200);
    private static final Point ON_SCREEN_POSITION = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() - 200);
    
    private ImageView sprite;

    private Spaceship()
    {
    	sprite = new ImageView(new Image("file:assets/temp_ship.png", SIZE, SIZE, false, false));
    }

    // Destroys Asteroid called when correct answer is given.
    public void shoot(Asteroid a)
    {
    	
    }
    
    public static synchronized Spaceship getInstance()
    {
    	// add ship to main window
    	INSTANCE.sprite.setX(OFF_SCREEN_POSITION.getX());
    	INSTANCE.sprite.setY(OFF_SCREEN_POSITION.getY());
    	MainWindow.getBorderPane().getChildren().add(INSTANCE.sprite);
    	
        return INSTANCE; 
    }
    
    // animation for spaceship to fly on screen from the bottom
    public void flyOnScreen()
    {	
    	// allow ship to fly up from under window
    	Path path = new Path();
    	path.getElements().add(new MoveTo(sprite.getX(), sprite.getY()));
    	path.getElements().add(new LineTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY()));
    	PathTransition pathTransition = new PathTransition();
    	pathTransition.setNode(sprite);
    	pathTransition.setPath(path);
    	pathTransition.setDuration(Duration.millis(FLY_UP_ANIMATION_DURATION));
    	
    	pathTransition.play();
    }
    
    // animation plays when incorrect answer is given
    public void shake()
    {
    	Path path = new Path();
    	path.getElements().add(new MoveTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY()));
    	path.getElements().add(new LineTo(ON_SCREEN_POSITION.getX() + 10, ON_SCREEN_POSITION.getY()));
    	//path.getElements().add(new LineTo(sprite.getX() - 10, sprite.getY()));
    	PathTransition pt = new PathTransition();
    	pt.setNode(sprite);
    	pt.setPath(path);
    	pt.setCycleCount(6);
    	pt.setAutoReverse(true);
    	pt.setDuration(Duration.millis(SHAKE_ANIMATION_DURATION));
    	
    	pt.play();
    }
    
    // animation for spaceship to fly offscreen when correct answer is given
    public void flyOffScreen()
    {
    	
    }
    
}
