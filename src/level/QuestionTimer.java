package level;

import application.GameLauncher;
import application.MainWindow;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class QuestionTimer
{
	private int secondsPerQuestion;
	private int timeLeft;
	private boolean timeUp;
	private Text text;
	
	public QuestionTimer(int sec)
	{
		secondsPerQuestion = sec;
		timeLeft = sec;
		timeUp = false;
	}
	
	public void startTimer()
	{	
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), ev -> 
			{
				timeLeft--;
				removeTimer();
				display();
			}
		));
		timer.setCycleCount(secondsPerQuestion);
		
		// if time runs out, increment attempt number
		timer.setOnFinished(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						
						
						GameLauncher.getLevel().advanceQuestion();
						GameLauncher.startGame();
					}
				});
		timer.play();
	}
	
	public void display()
	{
		text = new Text();
		text.setText(timeLeft + ":00");
		text.setFont(Font.font("Ariel", 25));
		text.setX(MainWindow.getWidth() - 100);
		text.setY(MainWindow.getHeight() - 175);
		
		MainWindow.getBorderPane().getChildren().add(text);
	}
	
	public void removeTimer()
	{
		MainWindow.getBorderPane().getChildren().remove(text);
	}
	
	public boolean isTimeUp()
	{
		return timeUp;
	}
}
