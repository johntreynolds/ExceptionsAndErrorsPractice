import java.io.IOException;

public class TakeStudentIndex
	{

		public static void main(String[] args) throws IOException
			{
				// Intro
				System.out.println("The CSV format is 'first last,GPA,");
				System.out.println(
						"This program allows for you to sort by First Name, Last Name, GPA, or Number of Infractions");
				System.out.println("You can also pick an index from a sorted list and get the student in that index");

				// Make Classroom
				Sorting.makeClassroom();

				// Empty Line
				System.out.println("");

				// Print Original, Unsorted Classroom
				Sorting.printClassroom();

				// Empty Line
				System.out.println("");

				// Ask for Choices
				Sorting.askForChoices();

				// Sort the Classroom According to User Choices
				Sorting.sortClassroom();
				
				// Empty Line
				System.out.println("");

				// Print out sorted list
				Sorting.printClassroom();
				
				// Empty Line
				System.out.println("");
				
				//Pick a Student Index
				Sorting.pickStudent();
			}

	}
