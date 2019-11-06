
public class Person
{
	private String name;
	private int age; 
	
	public Person(String intialName, int intialAge)
	{
		name = intialName;
		age = intialAge; 
	}
	
	public String toString()
	{
		return name + " is " + age + " years old.";
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void enterAge(int newAge)
	{
		age = newAge; 
	}
	
	public void enterName(String newName)
	{
		name = newName;
	}
	
	public int difference()
	{
		int newAge = 65 - getAge();
		return newAge;
		
	}
}


