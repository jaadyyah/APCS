
public class FirstString
{

	public static void main(String[] args)
	{
		String myName = "Jaadyyah Shearrion";

		System.out.println(myName.substring(0, 8));
		System.out.println(myName.substring(9));
		for (int i = 0; i <= myName.length() - 1; i++)
		{
			System.out.println(myName.charAt(i));
		}

	}

}
// it works its just if you wanted to put another name in it you would have to change some numbers around