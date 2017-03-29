package tests;

import questions.*;

public class QuestionTester
{
	public void main(String args[])
	{
		QuestionBank bank = new QuestionBank();
		
		Question q = new Level1Question1();
		
		Question curQ = bank.factory.createQuestion(q);
		
		System.out.println("Created sample question:");
		System.out.println(curQ.getQuestion() + " " + curQ.getAnswer());
	}
}
