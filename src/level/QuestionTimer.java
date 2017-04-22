package level;

import application.GameLauncher;
import application.MainWindow;
import javafx.animation.KeyFrame;
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
	private Text text;
	private Timeline timer;
	
	public QuestionTimer(int sec)
	{
		secondsPerQuestion = sec;
		timeLeft = sec;
		
		timer = new Timeline(new KeyFrame(Duration.millis(1000), ev -> 
		{
			timeLeft--;
			removeTimer();
			display();
		}
	));
	timer.setCycleCount(secondsPerQuestion);
	
	// if time runs out, tell the user, and advance to next question
	timer.setOnFinished(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					// advance question, makes screen blank
					GameLauncher.getLevel().advanceQuestion();
					
					// add text that says "Time's up!" to the screen
					Text text = new Text();
					text.setText("Time's up!");
					text.setFont(Font.font("Ariel", 40));				
					MainWindow.getBorderPane().setCenter(text);
					
					// let it linger for a bit
					Timeline t = new Timeline(new KeyFrame(Duration.millis(2500), ev -> {}));
					t.setCycleCount(1);
					
					// when timer is done running, remove text, display next question
					t.setOnFinished(new EventHandler<ActionEvent>()
							{
								@Override
								public void handle(ActionEvent e)
								{
									MainWindow.getBorderPane().getChildren().remove(text);
									GameLauncher.startGame();
								}
							});
					t.play();
				}
			});
	}
	
	public void startTimer()
	{	
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
	
	public void resetTimer()
	{
		timeLeft = secondsPerQuestion;
	}
	
	public void stopTimer()
	{
		timer.stop();
		
	}
}
