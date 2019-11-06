package Pets;

public class Cat
{
	private String name;
	
	public Cat(String n)
	{
		this.name = n;
	}
	
	public String speak()
	{
		return "Meow";
	}
	
	public String toString()
	{
		return this.name + " the cat";
	}
}
