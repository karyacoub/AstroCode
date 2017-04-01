package questiontypes;

import questions.Question;

public class Level1Question5 extends Question
{
	public Level1Question5()
	{
		question = "boolean a = true; boolean b = true; !a && b = ?";
		actualAnswer = "false";
		possibleAnswer1 = "true";
		possibleAnswer2 = "false";
		possibleAnswer3 = "neither";
	}
}