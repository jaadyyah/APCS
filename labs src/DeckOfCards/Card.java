package DeckOfCards;

public class Card implements Comparable <Card>
{
	int value;
	String suit;

	public Card(int v, String s)
	{
		value = v;
		suit = s;
	}

	public String toString()
	{
		if (value == 1)
		{
			System.out.print("Ace" + " of " + suit);
		}
		
		if (value < 10 && value >= 2)
		{
			System.out.print(value + " of " + suit);
		}
		
		if (value == 11)
		{
			System.out.print("Jack" + " of " + suit);
		}
			
		if (value == 12)
		{
			System.out.print("Queen" + " of " + suit);
		}
			
		if (value == 13)
		{
			System.out.print("King" + " of " + suit);
		}
		return "";
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			Card c = new Card((int) (Math.random() * 13 + 1), "Clubs");
			System.out.println(c);
		}
	}

	public int compareTo(Card other)
	{
		return value - other.value;
	}

}