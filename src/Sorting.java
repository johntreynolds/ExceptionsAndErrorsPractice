
//All da imports
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Sorting implements Comparator<Student>
	{
		static int sortChooseNumber;
		static int sortLetterNumber;
		static int sortHighLowNumber;

		// instantiate new arraylist of student objects in an ArrayList called classroom
		static ArrayList<Student> classroom = new ArrayList<>();

		public static void makeClassroom() throws IOException
			{
				try
					{

						// Scanner for the .txt file
						Scanner myFile = new Scanner(new File("NamesGPAInfractionList.csv"));
						// Glosses over the introductory line in the CSV file
						// Adds all of the data to the arraylist
						while (myFile.hasNextLine())
							{
								// makes name the next line in the .txt file and adds that "name" the next name
								// added to the arraylist
								// Provides for "parametric" i guess editing of the text file for the program to
								// still function
								String line = myFile.nextLine().trim();

								if (line.isEmpty())
									{
										continue;
									}
								String[] data = line.split(",");
								String firstName = data[0].substring(0, data[0].lastIndexOf(" "));
								String lastName = data[0].substring(data[0].lastIndexOf(" ") + 1);
								double GPA = Double.parseDouble(data[1]);
								int infractions = Integer.parseInt(data[2]);
								classroom.add(new Student(firstName, lastName, GPA, infractions));
							}

					} catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e)
					{
						System.out.println("Error: A line in the CSV file is missing or NOT in the improper format");
						System.out.println("The correct format is 'First Last,GPA,Infractions'");
					} catch (IOException e)
					{
						System.out.println("Error: Could not find file");
					}

			}

		public static void printClassroom()
			{
				for (Student s : classroom)
					{
						System.out.println(s.getLastName() + ", " + s.getFirstName() + ", " + s.getGPA() + ", "
								+ s.getInfractions());
					}
			}

		public static void askForChoices()
			{
				
				System.out.println("What would you like to sort by?");
				System.out.println("1) First Name");
				System.out.println("2) Last Name");
				System.out.println("3) GPA");
				System.out.println("4) Number of Infractions");
				Scanner userIntInput = new Scanner(System.in);
				sortChooseNumber = userIntInput.nextInt();
				if (sortChooseNumber == 1 || sortChooseNumber == 2)
					{
						System.out.println("Would you like to sort A-Z or Z-A?");
						System.out.println("1) A-Z");
						System.out.println("2) Z-A");
						sortLetterNumber = userIntInput.nextInt();
					}
				if (sortChooseNumber == 3 || sortChooseNumber == 4)
					{
						System.out.println("Would you like to sort highest-lowest or lowest-highest");
						System.out.println("1) Highest-Lowest");
						System.out.println("2) Lowest-Highest");
						sortHighLowNumber = userIntInput.nextInt();
					}

			}

		@Override
		public int compare(Student s1, Student s2)
			{
				int result = 0;
				switch (sortChooseNumber)
					{
					case 1:
						{
							// Sorts First Name by A-Z
							result = s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
							// Swaps the sort if sorting Z-A is selected
							if (sortLetterNumber == 2)
								{
									result *= -1;
								}
							break;
						}
					case 2:
						{
							// Sorts LAST Name by A-Z
							result = s1.getLastName().compareToIgnoreCase(s2.getLastName());
							// Swaps the sort if sorting Z-A is selected
							if (sortLetterNumber == 2)
								{
									result *= -1;
								}
							break;
						}
					case 3:
						{
							// Sorts GPA highest to lowest
							result = Double.compare(s2.getGPA(), s1.getGPA());
							// Swaps the sort if sorting lowest-highest is selected
							if (sortHighLowNumber == 2)
								{
									result *= -1;
								}
							break;
						}
					case 4:
						{
							// Sorts GPA highest to lowest
							result = Double.compare(s2.getInfractions(), s1.getInfractions());
							// Swaps the sort if sorting lowest-highest is selected
							if (sortHighLowNumber == 2)
								{
									result *= -1;
								}
							break;
						}
					}
				return result;
			}

		public static void sortClassroom()
			{
				Collections.sort(classroom, new Sorting());
			}

		public static void pickStudent()
			{
				System.out.println("Would you like to find the index of a specific student rank?");
				System.out.println("1) Yes");
				System.out.println("2) No");
				Scanner userIntInput = new Scanner(System.in);
				int findIndex = userIntInput.nextInt();
				try
					{
						if (findIndex == 1)
							{
								System.out.println("Pick the rank you want to select");
								int index = userIntInput.nextInt();

								switch (sortChooseNumber)
									{
									case 1:
									case 2:
										{
											System.out.println(classroom.get(index - 1).getLastName() + ", "
													+ classroom.get(index - 1).getFirstName());
											break;
										}
									case 3:
										{
											System.out.println(classroom.get(index - 1).getLastName() + ", "
													+ classroom.get(index - 1).getFirstName() + ", "
													+ classroom.get(index - 1).getGPA());
											break;
										}
									case 4:
										{
											System.out.println(classroom.get(index - 1).getLastName() + ", "
													+ classroom.get(index - 1).getFirstName() + ", "
													+ classroom.get(index - 1).getInfractions());
											break;
										}
									}

							}

						else
							{
								System.out.println("Ok");
								System.exit(0);
							}
					} catch (

						IndexOutOfBoundsException e)
					{
						System.out.println("You entered an index for a student that doesn't exist");
						System.out.println("Try Again");

						pickStudent();
					}
			}
	}
