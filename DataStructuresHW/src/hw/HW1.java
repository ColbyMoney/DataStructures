package hw;

public class HW1 {	
	//main
	public static void main(String[] args)
	{
		System.out.println(score2letterGrade(100, 67));
		System.out.println(score2letterGrade(133, 67));
		System.out.println(score2letterGrade(81, 67));
		System.out.println(score2letterGrade(69, 67));
		displayLinearSpace(10,20,2);
		displayLinearSpace(1,78,4);
	}
	
	//return score letter grade based on score % of max
	static String score2letterGrade(double max, double score)
	{
		//percent for the score for calculating the grade
		double percent = 100 * (score/max);
		
		//run through each grade range to test for the letter grade
		if (percent >= 90.0)
			return "A";
		else if (percent >= 80.0 && percent < 90.0)
			return "B";
		else if (percent >= 70.0 && percent < 80.0)
			return "C";
		else if (percent >= 60.0 && percent <70.0)
			return "D";
		else if (percent < 60.0)
			return "F";
		
		return "";
	}
	
	//display equally spaced intervals from start to end
	static void displayLinearSpace(double start, double end, int count)
	{
		//interval for each number
		double interval = (end - start) / (count-1);
		
		//print each number
		for (int i = 0; i < count; i++)
		{
			System.out.print((start + (interval*i)) + " ");
		}
		System.out.println();
	}
}
