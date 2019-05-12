
public class Person 
{
	public int age;
	public int BirthYear;
	
	
	public String FirstName;
	public String MiddleName;
	public String LastName;
	
	public boolean IsMarried;
	public boolean IsDead;
	public boolean IsEmployed;
	public boolean IsLawEnforcement;
	public boolean isMilitary;
	public boolean isStudent;
	public boolean isIncarcerated;
	
	public Person[] children;
	public Person father;
	public Person mother;
	
	
    
    public Person() 
    {
	

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

	public String getFirstName() {
		return FirstName;
	}
}
