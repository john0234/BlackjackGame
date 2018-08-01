import java.util.ArrayList;
import java.util.Random;

public class Card {
	 
	private static String values = "2,3,4,5,6,7,8,9,10,J,Q,K,A";
	private static String types = "Hearts,Diamonds,Spades,Clubs";
	private static String[] valArr = values.split(",");
	private static String[] typeArr = types.split(",");
	
	private String type;
	private String value;
	
	public Card()
	{		
		Random r = new Random();		
		int rand = r.nextInt(valArr.length);		
		this.value = valArr[rand];
		rand = r.nextInt(typeArr.length);
		this.type = typeArr[rand];		
	} 
	
	public Card(String value, String type)
	{
		if(!types.contains(type))
		{
			System.out.print("Invalid Type");
		}
		else if(!values.contains(value))
		{
			System.out.print("Invalid Value");
		}
		else
		{
			this.type = type;
			this.value = value;
		}	
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getVal()
	{
		if(this.value.equalsIgnoreCase("J"))
		{
			return "10";
		}
		else if(this.value.equalsIgnoreCase("Q"))
		{
			return "10";
		}
		else if(this.value.equalsIgnoreCase("K"))
		{
			return "10";
		}
		else if(this.value.equalsIgnoreCase("A"))
		{
			return this.value;
		}
		else
		{
			return this.value;
		}		
	}
	
	public String toString()
	{
		String ret = "";
		ret += value + " of " + type;		
		return ret;
	}
	
	public static Card[] standardDeck()
	{
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0 ; i < valArr.length ; i++)
		{
			for(int j = 0; j < typeArr.length; j++)
			{
				cards.add(new Card(valArr[i],typeArr[j]));
			}
		}
		Card[] newCards = new Card[cards.size()];
		for(int i = 0; i < cards.size(); i++)
		{
			newCards[i] = cards.get(i);
		}
		return newCards;
	}
	
	
	
}
