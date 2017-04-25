package level;

import application.GameLauncher;
import application.MainWindow;
import asteroids.Asteroid;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.Point;

public class Spaceship
{
    private static final Spaceship INSTANCE = new Spaceship();
    private static final double SIZE = 80;
    private static final int FLY_UP_ANIMATION_DURATION = 1000;
    private static final int SHAKE_ANIMATION_DURATION = 80;
    private static final int BULLET_ANIMATION_DURATION = 200;
    private static final Point OFF_SCREEN_POSITION_BOTTOM = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() + 200);
    private static final int OFF_SCREEN_POSITION_TOP = (int)(0-SIZE);
    private static final Point ON_SCREEN_POSITION = new Point(MainWindow.getWidth() / 2, MainWindow.getHeight() - 200);
    
    private ImageView sprite;

    private Spaceship()
    {
    	sprite = new ImageView(new Image("file:assets/temp_ship.png", SIZE, SIZE, false, false));
    }

    // Destroys Asteroid called when correct answer is given.
    public void shoot(Asteroid a)
    {
    	Rectangle bullet = new Rectangle(10, 10);
    	
    	// shoot asteroid
    	Path path = new Path();
    	path.getElements().add(new MoveTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY() - SIZE + 35));
    	path.getElements().add(new LineTo(a.getPosition().getX(), a.getPosition().getY()));
    	PathTransition pt = new PathTransition();
    	pt.setNode(bullet);
    	pt.setPath(path);
    	pt.setDuration(Duration.millis(BULLET_ANIMATION_DURATION));
    	
    	// when asteroid is shot, asteroid starts blinking and eventually disappears
    	pt.setOnFinished(new EventHandler<ActionEvent>()
    			{
    				@Override
    				public void handle(ActionEvent e)
    				{	
    					MainWindow.getBorderPane().getChildren().remove(bullet);
    					FadeTransition ft = new FadeTransition();
    			    	ft.setNode(a.getSprite());
    			    	ft.setCycleCount(5);
    			    	ft.setFromValue(1.0);
    			    	ft.setToValue(0.1);
    			    	ft.setAutoReverse(true);
    			    	
    			    	ft.setOnFinished(new EventHandler<ActionEvent>()
    			    			{
    			    				@Override
    			    				public void handle(ActionEvent e)
    			    				{
    			    					MainWindow.getBorderPane().getChildren().remove(a.getSprite());
    			    					flyOffScreen(a);
    			    				}
    			    			});
    			    	
    			    	ft.play();
    				}
    			});
    	
    	MainWindow.getBorderPane().getChildren().add(bullet);
    	pt.play();
    }
    
    public static synchronized Spaceship getInstance()
    {
    	// add ship to main window
    	INSTANCE.sprite.setX(OFF_SCREEN_POSITION_BOTTOM.getX());
    	INSTANCE.sprite.setY(OFF_SCREEN_POSITION_BOTTOM.getY());
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
    	PathTransition pt = new PathTransition();
    	pt.setNode(sprite);
    	pt.setPath(path);
    	pt.setCycleCount(6);
    	pt.setAutoReverse(true);
    	pt.setDuration(Duration.millis(SHAKE_ANIMATION_DURATION));
    	
    	pt.play();
    }
    
    // animation for spaceship to fly offscreen when correct answer is given
    public void flyOffScreen(Asteroid a)
    {
    	int positionIndex = a.getPositionIndex();
    	
    	RotateTransition rt = new RotateTransition();
    	rt.setNode(sprite);
    	
    	// leftmost asteroid
    	if(positionIndex == 1)
    	{
    		// rotate to the left
    		rt.setByAngle(-90);
    		
    		rt.setOnFinished(new EventHandler<ActionEvent>()
    		{
    			@Override
    			public void handle(ActionEvent e)
    			{
    				// move under the asteroid
    	    		Path path = new Path();
    	    		path.getElements().add(new MoveTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY()));
    	    		path.getElements().add(new LineTo(a.getPosition().getX(), ON_SCREEN_POSITION.getY()));
    	    		PathTransition pt = new PathTransition();
    	    		pt.setNode(sprite);
    	    		pt.setPath(path);
    	    		
    	    		pt.setOnFinished(new EventHandler<ActionEvent>()
    	    		{
    	    			@Override
    	    			public void handle(ActionEvent e)
    	    			{
    	    				// rotate towards asteroid
    	    				RotateTransition rt = new RotateTransition();
    	    				rt.setNode(sprite);
    	    				rt.setByAngle(90);
    	    				
    	    				rt.setOnFinished(new EventHandler<ActionEvent>()
    	    	    		{
    	    	    			@Override
    	    	    			public void handle(ActionEvent e)
    	    	    			{
    	    	    				// fly up to the top of the window
    	    	    				Path path = new Path();
    	    	    	    		path.getElements().add(new MoveTo(a.getPosition().getX(), ON_SCREEN_POSITION.getY()));
    	    	    	    		path.getElements().add(new LineTo(a.getPosition().getX(), OFF_SCREEN_POSITION_TOP));
    	    	    	    		PathTransition pt = new PathTransition();
    	    	    	    		pt.setNode(sprite);
    	    	    	    		pt.setPath(path);
    	    	    	    		
    	    	    	    		// advance question
    	    	    	    		pt.setOnFinished(new EventHandler<ActionEvent>()
    	    	    	    		{
    	    	    	    			@Override
    	    	    	    			public void handle(ActionEvent e)
    	    	    	    			{
    	    	    	    				GameLauncher.getLevel().advanceQuestion();
    	        							GameLauncher.startGame();
    	    	    	    			}
    	    	    	    		});	
    	    	    	    		
    	    	    	    		pt.play();
    	    	    			}
    	    	    		});	
    	    				
    	    				rt.play();
    	    			}
    	    		});	
    	    		pt.play();
    			}
    		});	
    		
    		rt.play();
    	}
    	
    	// center asteroid
    	else if(positionIndex == 2)
    	{
    		// fly up to the top of the window
			Path path = new Path();
    		path.getElements().add(new MoveTo(a.getPosition().getX(), ON_SCREEN_POSITION.getY()));
    		path.getElements().add(new LineTo(a.getPosition().getX(), OFF_SCREEN_POSITION_TOP));
    		PathTransition pt = new PathTransition();
    		pt.setNode(sprite);
    		pt.setPath(path);
    		
    		// advance question
    		pt.setOnFinished(new EventHandler<ActionEvent>()
    		{
    			@Override
    			public void handle(ActionEvent e)
    			{
    				GameLauncher.getLevel().advanceQuestion();
					GameLauncher.startGame();
    			}
    		});	
    		
    		pt.play();
    	}
    	
    	// rightmost asteroid
    	else
    	{
    		// rotate to the right
    		rt.setByAngle(90);
    		
    		rt.setOnFinished(new EventHandler<ActionEvent>()
    		{
    			@Override
    			public void handle(ActionEvent e)
    			{
    				// move under the asteroid
    	    		Path path = new Path();
    	    		path.getElements().add(new MoveTo(ON_SCREEN_POSITION.getX(), ON_SCREEN_POSITION.getY()));
    	    		path.getElements().add(new LineTo(a.getPosition().getX(), ON_SCREEN_POSITION.getY()));
    	    		PathTransition pt = new PathTransition();
    	    		pt.setNode(sprite);
    	    		pt.setPath(path);
    	    		
    	    		pt.setOnFinished(new EventHandler<ActionEvent>()
    	    		{
    	    			@Override
    	    			public void handle(ActionEvent e)
    	    			{
    	    				// rotate towards asteroid
    	    				RotateTransition rt = new RotateTransition();
    	    				rt.setNode(sprite);
    	    				rt.setByAngle(-90);
    	    				
    	    				rt.setOnFinished(new EventHandler<ActionEvent>()
    	    	    		{
    	    	    			@Override
    	    	    			public void handle(ActionEvent e)
    	    	    			{
    	    	    				// fly up to the top of the window
    	    	    				Path path = new Path();
    	    	    	    		path.getElements().add(new MoveTo(a.getPosition().getX(), ON_SCREEN_POSITION.getY()));
    	    	    	    		path.getElements().add(new LineTo(a.getPosition().getX(), OFF_SCREEN_POSITION_TOP));
    	    	    	    		PathTransition pt = new PathTransition();
    	    	    	    		pt.setNode(sprite);
    	    	    	    		pt.setPath(path);
    	    	    	    		
    	    	    	    		// advance question
    	    	    	    		pt.setOnFinished(new EventHandler<ActionEvent>()
    	    	    	    		{
    	    	    	    			@Override
    	    	    	    			public void handle(ActionEvent e)
    	    	    	    			{
    	    	    	    				GameLauncher.getLevel().advanceQuestion();
    	        							GameLauncher.startGame();
    	    	    	    			}
    	    	    	    		});	
    	    	    	    		
    	    	    	    		pt.play();
    	    	    			}
    	    	    		});	
    	    				
    	    				rt.play();
    	    			}
    	    		});	
    	    		pt.play();
    			}
    		});	
    		
    		rt.play();

    	}
    }
    
}
