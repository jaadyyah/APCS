package newPets;

public class PetSitter
{
	public static void main(String[] args)
	{
		Dog fido = new Dog("Fido");
		System.out.println(fido + " says, \"" + fido.speak() + "\"");

		LoudDog rocko = new LoudDog("Rocko");
		System.out.println(rocko + " says, \"" + rocko.speak() + "\"");

		Rabbit spot = new Rabbit("Boing");
		Cat fluffy = new Cat("Fluffy");

		Pet[] pets = new Pet[4];
		pets[0] = rocko;
		pets[1] = fido;
		pets[2] = fluffy;
		pets[3] = spot;

		fluffy.scratch();
		((Cat)pets[2]).scratch();

		System.out.println();
		// for each loop
		for (Pet p : pets)
		{
			System.out.println(p.speak());
		}
	}
}