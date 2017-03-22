package questions;

import questions.Question;
import questions.QuestionBank;

public class QuestionTester
{
	public void main(String args[])
	{
		QuestionBank bank = new QuestionBank();
		
		Question q = new Question();
		
		Question curQ = bank.factory.createQuestion(q);
		
		System.out.println("Created sample question:");
		System.out.println(curQ.getQuestion() + " " + curQ.getAnswer());
	}
}
