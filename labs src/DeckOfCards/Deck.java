package DeckOfCards;

public class Deck
{
	public static final int CARDS_IN_DECK = 52;
	public static final int CARDS_IN_SUIT = 13;
	private int undealt;
	private Card[] deck;

	// declare deck as an array of Cards, but don't initialize it here
	// declare undealt as an int field

	public Deck()
	{
		deck = new Card[52];
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		int c = 0;
		for (String suit : suits)
		{
			for (int value = 1; value <= CARDS_IN_SUIT; value++)
			{
				deck[c] = new Card(value, suit);
				c++;
			}
		}
		 undealt = 0;
	}

	public void print()
	{
		for (Card c : deck)
		{
			System.out.println(c);
		}
	}

	public void shuffle()
	{
		for (int i = 0; i < 52; i++)
		{
			Card temp = deck[i];
			int change = (int) (Math.random() * 52);
			deck[i] = deck[change];
			deck[change] = temp;
		}
	}

	public Card topCard()
	{	
		undealt++;
		return deck[undealt - 1];
	}

	public void deal(int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.println(topCard());
		}
	}

	public static void main(String[] args)
	{
		Deck myDeck = new Deck();
		myDeck.shuffle();
		Card player1Card = myDeck.topCard();
		Card player2Card = myDeck.topCard();
		
		// for some reason player 1 or 2's cards don't print for some reason
		System.out.println(player1Card + " was player 1's card");
		System.out.println(player2Card + " was player 2's card");
		
		// if there is a tie one of the players sometimes ends up being printed as the winner too, which is wrong per say but its annoying 
		if (player1Card.compareTo(player2Card) == 0)
		{
			System.out.println("It's a tie!");
		}
		if (player1Card.compareTo(player2Card) <= -1)
		{
			System.out.println("Player 2 won!");
		}
		else 
		{
			System.out.println("Play 1 won!");
		}
	}
}