package Pets;

public class AngryDog extends Dog
{	
	public AngryDog(String name)
	{
		super(name);
	}
	
	public String speak()
	{
		return "Grrrrr..." + super.speak();
	}
}
