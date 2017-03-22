package questions;

public class QuestionBank
{
	public QuestionFactory factory;
	Question curQuestion;
	
	void setCurQuestion(Question q)
	{
		curQuestion = q;
	}
	
	void nextQuestion()
	{
		System.out.println("getting next question");
	}
}
