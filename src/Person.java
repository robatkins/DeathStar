
public class Person 
{
	public int age;
	public int BirthYear;
	
	public char gender;
	
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
	
	
	public Person father;
	public Person mother;
	public Person[] children;
	public Person[] siblings;
	
	
	
	public Phone[] getPhone() {
		return phone;
	}



	public void setPhone(Phone[] phone) {
		this.phone = phone;
	}



	public Computer[] getComputer() {
		return computer;
	}



	public void setComputer(Computer[] computer) {
		this.computer = computer;
	}



	public String[] getFacebookProfileURL() {
		return facebookProfileURL;
	}



	public void setFacebookProfileURL(String[] facebookProfileURL) {
		this.facebookProfileURL = facebookProfileURL;
	}



	public String[] getTwitterProfileURL() {
		return twitterProfileURL;
	}



	public void setTwitterProfileURL(String[] twitterProfileURL) {
		this.twitterProfileURL = twitterProfileURL;
	}



	public String[] getInstagramProfileURL() {
		return instagramProfileURL;
	}



	public void setInstagramProfileURL(String[] instagramProfileURL) {
		this.instagramProfileURL = instagramProfileURL;
	}

	public Phone[] phone;
	public Computer[] computer;
	
	public String[] facebookProfileURL;
	public String[] twitterProfileURL;
	public String[] instagramProfileURL;
	
	
	
	
    
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
