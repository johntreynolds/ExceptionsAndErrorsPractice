public class Student
	{
		private String firstName;
		private String lastName;
		private double GPA;
		private int infractions;

		public Student(String firstName, String lastName, double GPA, int infractions)
			{
				this.firstName = firstName;
				this.lastName = lastName;
				this.GPA = GPA;
				this.infractions = infractions;
			}

		public String getFirstName()
			{
				return firstName;
			}

		public void setFirstName(String firstName)
			{
				this.firstName = firstName;
			}

		public String getLastName()
			{
				return lastName;
			}

		public void setLastName(String lastName)
			{
				this.lastName = lastName;
			}

		public double getGPA()
			{
				return GPA;
			}

		public void setGPA(double gPA)
			{
				GPA = gPA;
			}

		public int getInfractions()
			{
				return infractions;
			}

		public void setInfractions(int infractions)
			{
				this.infractions = infractions;
			}

		
	}
