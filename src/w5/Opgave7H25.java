package w5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Opgave7H25
{
	List<Card> cards;
	String[] c = {"diamonds", "hearts", "spades", "clubs"};
	String[] op = {"*","/","+","-"};
	
	public Opgave7H25()
	{
		cards = new ArrayList<Card>();
		for(int x = 0; x < c.length; x++)
		{
			for(int i = 1; i <= 13; i++)
			{
				cards.add(new Card(i, c[x]));
			}
		}
		
		System.out.println("# of cards : "+ cards.size());
		
		Set<Card> hand = new LinkedHashSet<Card>();
		while(hand.size() < 4)
		{
			hand.add(cards.get( (int) (Math.random() *cards.size() ) ) );
			System.out.println(hand.size() +" : the card : "+hand.toArray()[hand.size()-1]);
		}
		
		
		verify("4387*4738*421*12/434-411+3112+311");
	}
	
	public boolean verify(String expression)
	{

		return false;
	}
	
	public static void main(String[] arg)
	{
		new Opgave7H25();
	}
	
	
	public class Card
	{
		int nmbr;
		String colour;
		
		public Card(int nmbr, String colour)
		{
			this.nmbr = nmbr;
			this.colour = colour;
		}
		
		public String toString()
		{
			return ""+nmbr+" of "+colour;
		}
	}
}