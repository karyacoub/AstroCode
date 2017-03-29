package questions;

import application.MainWindow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class Question
{
	protected String question;
	protected String possibleAnswer1;
	protected String possibleAnswer2;
	protected String possibleAnswer3;
	protected String actualAnswer;
	
	public void display()
	{
		Text text = new Text();
		text.setText(question);
		text.setX(MainWindow.getWidth() / 2 - 400);
		text.setY(100);
		text.setFont(Font.font("Ariel", 35));
		MainWindow.getBorderPane().setTop(text);
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return actualAnswer;
	}
}
