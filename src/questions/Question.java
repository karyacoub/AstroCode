package questions;

import application.MainWindow;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
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
		text.setFont(Font.font("Ariel", 35));
		
		// align text to center
		HBox textAlign = new HBox();
		textAlign.getChildren().add(text);
		textAlign.setAlignment(Pos.CENTER);
		
		MainWindow.getBorderPane().setTop(textAlign);
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
