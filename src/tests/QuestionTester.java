package tests;

import questions.*;
import questiontypes.Level1Question1;

public class QuestionTester
{
	public void main(String args[])
	{
		QuestionBank bank = new QuestionBank();
		
		Question curQ = bank.factory.getQuestion();
		
		System.out.println("Created sample question:");
		System.out.println(curQ.getQuestion() + " " + curQ.getAnswer());
	}
}
