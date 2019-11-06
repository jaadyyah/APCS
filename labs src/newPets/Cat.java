package newPets;

public class Cat extends Pet
{
	public Cat(String n)
	{
		super(n);
	}

	public void scratch()
	{
		System.out.println("Scratching");
	}

	public String speak()
	{
		return "Meow";
	}
}