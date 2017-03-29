package questions;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import questiontypes.*;

public class QuestionFactory
{
	private String windowsDir = System.getProperty("user.dir") + "\\src\\questiontypes\\";
	private String linuxDir = System.getProperty("user.dir") + "/src/questiontypes/";
	// stores the names of all question classes in array
	private String[] questions = new File(windowsDir).list();
	// find the total number of questions present
	private int numQuestions;
	private int curQuestion = 0;
	
	// returns the last unanswered question
	public Question getQuestion()
	{
		if(questions == null) 
		{ 
			questions =  new File(linuxDir).list();
		}
		numQuestions = questions.length;
		
		if(curQuestion < numQuestions) { curQuestion++; } 
		Question q =  getClassFromFile(curQuestion - 1);
		return q;
	}
	
	// return instance of a class from filename
	// credit for this goes to StackOverflow user TurtleToes
	// http://stackoverflow.com/questions/5401467/convert-string-into-a-class-object
	private Question getClassFromFile(int i)
	{
		Object o = null;
		try 
		{
			// remove the file extension (.java) so that the string can be used with Class.forname()
			questions[i] = questions[i].substring(0, questions[i].length() - 5);
			o = Class.forName("questiontypes." + questions[i]).newInstance();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return (Question)o;
	}
}
