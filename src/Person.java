
public class Person 
{
	public int age;
	public String FirstName;
	public String MiddleName;
	public String LastName;
	public boolean IsMarried;
	public boolean IsDead;
	public boolean IsEmployed;
	public int NumberOfChildren;
	public int NumberOfPets;
    
    public Person() 
    {
	

    }
    
    public Person(int age, String firstName, String middleName, String lastName, boolean isMarried, boolean isDead,
			boolean isEmployed, int numberOfChildren, int numberOfPets) {
		super();
		this.age = age;
		FirstName = firstName;
		MiddleName = middleName;
		LastName = lastName;
		IsMarried = isMarried;
		IsDead = isDead;
		IsEmployed = isEmployed;
		NumberOfChildren = numberOfChildren;
		NumberOfPets = numberOfPets;
	}

	public void setFirstName(String x)
    {
    	this.FirstName = x;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public boolean isIsMarried() {
		return IsMarried;
	}

	public void setIsMarried(boolean isMarried) {
		IsMarried = isMarried;
	}

	public boolean isIsDead() {
		return IsDead;
	}

	public void setIsDead(boolean isDead) {
		IsDead = isDead;
	}

	public boolean isIsEmployed() {
		return IsEmployed;
	}

	public void setIsEmployed(boolean isEmployed) {
		IsEmployed = isEmployed;
	}

	public int getNumberOfChildren() {
		return NumberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		NumberOfChildren = numberOfChildren;
	}

	public int getNumberOfPets() {
		return NumberOfPets;
	}

	public void setNumberOfPets(int numberOfPets) {
		NumberOfPets = numberOfPets;
	}

	public String getFirstName() {
		return FirstName;
	}
}
