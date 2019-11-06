package newPets;

public abstract class Pet
{
	private String name;

	public Pet(String initialName)
	{
		name = initialName;
	}

	public String toString()
	{
		return name + " the " + getClass().getSimpleName();
	}

	public abstract String speak();
}
