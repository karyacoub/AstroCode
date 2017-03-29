package questions;

public class QuestionBank
{
	public QuestionFactory factory = new QuestionFactory();
	Question curQuestion;
	
	public QuestionBank()
	{
		curQuestion = factory.getQuestion();
	}
	
	public void displayCurQuestion()
	{
		curQuestion.display();
	}
	
	public void setCurQuestion(Question q)
	{
		curQuestion = q;
	}
	
	public Question getCurQuestion()
	{
		return curQuestion;
	}
	
	public void nextQuestion()
	{
		curQuestion = factory.getQuestion();
	}
}
