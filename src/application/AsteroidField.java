/** AsteroidField.java **/
// contains code pertaining to falling asteroids in the simulation, will be used as a node for the main window

package application;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class AsteroidField extends Parent
{
	private Asteroid currentAsteroid; // asteroid that is currently on screen
	
	public AsteroidField()
	{
		super();
		currentAsteroid = new Asteroid();
	}
	
	// starts the simulation
	public void runSimulation()
	{
		ImageView iv = new ImageView(currentAsteroid.getImage());
		Main.getBorderPane().getChildren().add(iv);
		Path path = new Path();
		PathTransition pathTransition = new PathTransition();
		
		path.getElements().add(new MoveTo(currentAsteroid.getX(), currentAsteroid.getY()));
		path.getElements().add(new LineTo(Main.getWidth() / 2, Main.getHeight() + currentAsteroid.getSize()));
		
		pathTransition.setDuration(Duration.millis(currentAsteroid.getSpeed() * 1000));
		pathTransition.setPath(path);
		pathTransition.setNode(iv);
		pathTransition.setCycleCount(1);
		
		pathTransition.play();
		
		pathTransition.setOnFinished(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						runSimulation();
					}
				}
		);
	}
}
