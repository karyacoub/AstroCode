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
	private Text text;
	
	public void display()
	{
		text = new Text();
		text.setText(question);
		text.setFont(Font.font("Ariel", 35));
		
		// align text to center
		HBox textAlign = new HBox();
		textAlign.getChildren().add(text);
		textAlign.setAlignment(Pos.CENTER);
		
		MainWindow.getBorderPane().setTop(textAlign);
	}
	
	public void removeText()
	{
		MainWindow.getBorderPane().getChildren().remove(text);
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getPossibleAnswer1()
	{
		return possibleAnswer1;
	}
	
	public String getPossibleAnswer2()
	{
		return possibleAnswer2;
	}
	
	public String getPossibleAnswer3()
	{
		return possibleAnswer3;
	}
	
	public String getAnswer()
	{
		return actualAnswer;
	}
}
