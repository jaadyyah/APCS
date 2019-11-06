import java.util.ArrayList;

public class ArrayListExample
{
	public static void main(String[] args)
	{
		ArrayList<String> motto = new ArrayList<String>();
		motto.add("Diversity");
		motto.add("Opportunity");
		motto.add("Respect");
		System.out.println(motto);

		for (int index = 1; index < motto.size(); index += 2)
		{
			String temp = motto.get(index - 1); 
			motto.set(index - 1, motto.get(index)); 
			motto.set(index, temp);
		}
		System.out.println(motto);

	}
}