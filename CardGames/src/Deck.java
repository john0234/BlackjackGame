import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck extends Card
{	
	ArrayList<Card> deck = new ArrayList<>();
	
	public Deck(Card[] deck)
	{
		this.deck = new ArrayList<Card>(Arrays.asList(deck));
	}
	
	public Deck()
	{
		this.deck = new ArrayList<Card>();
	}
	
	public boolean isEmpty()
	{
		return deck.isEmpty();
	}
	
	public Card dealTop()
	{
		if(deck.size() == 0)
		{
			return null;
		}
		Card ret = deck.get(deck.size()-1);
		deck.remove(ret);
		return ret;
	}
	
	public void insertAtRandom(Card c)
	{
		Random r = new Random();
		deck.add(r.nextInt(deck.size()+1), c);		
	}
	
	public void shuffle()
	{
		shuffleTranspositions();
	}
	
	public void cutAtSpot(int pos)
	{
		Card[] ncards = (Card[]) (new Object[deck.size()]);
		System.arraycopy(deck.toArray(), pos, ncards, 0, deck.size()-pos);
		System.arraycopy(deck.toArray(), 0, ncards, deck.size()-pos, pos);
		deck = new ArrayList<Card>(Arrays.asList(ncards));
 	}//cutAtSpot
	
 	public void cutAtMiddle()
 	{
		cutAtSpot(deck.size()/2);
	}//cutAtMiddle

	private void shuffleTranspositions()
	{
		for(int i=0; i<deck.size()*deck.size()*2; i++)
		{
			Random r = new Random();
			int firstCardPos = r.nextInt(deck.size());
			int secondCardPos = r.nextInt(deck.size());
			Card firstCard = deck.get(firstCardPos);
			Card secondCard = deck.get(secondCardPos);

			deck.set(firstCardPos, secondCard);
			deck.set(secondCardPos, firstCard);
		}//for

	}//shuffleTranspositions()
	
	private void insert(Card c, int position)
	{
		if(position<0 || position>deck.size()){throw new IllegalArgumentException("Invalid position");}
		deck.add(position, c);
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(int i = deck.size()-1; i >= 0; i--)
		{
			Card c = deck.get(i);
			s += c.toString();
			s += "\n";
		}//for
		return s;
	}//toString()
	
	public int size()
	{
		return deck.size();
	}
	
	
	
}
