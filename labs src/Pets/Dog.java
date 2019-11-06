package Pets;
public class Dog 
{
	private String name;
	
	public Dog(String n)
	{
		this.name = n;
	}
	
	public String speak()
	{
		return "Woof!";
	}
	
	public String toString()
	{
		return this.name + " the dog";
	}
}