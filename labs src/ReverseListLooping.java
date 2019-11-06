import java.util.ArrayList;
import java.util.Arrays;

public class ReverseListLooping
{

    public static void main(String[] args)
    {
        ArrayList<String> fred = new ArrayList<String>(Arrays.asList("have still you learn to much".split(" ")));
        System.out.println(fred.toString());
        reverse(fred);
        System.out.println(fred.toString());
    }

	private static void reverse(ArrayList<String> fred)
	{
		for(int i = fred.size() - 1; i >= 0; i--)
		{
			fred.add(fred.get(i));
		}
		return;
	}

}