import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args)
	{
		System.out.println("Welcome to Blackjack!");
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = sc.next();
		String input = name;
		//boolean bust;
		Deck holder = new Deck();
		System.out.println("How much $$ would you like to start with?");
		while(!sc.hasNextInt())
		{
			System.out.println("Sorry, please type in a number");
			sc.next();
			
		}
		int StartAmount = sc.nextInt();
		//System.out.println(StartAmount);
		boolean buyin = false;

		Deck graveyard = new Deck();
		Deck deck = new Deck(Card.standardDeck());
		int sum = 0;
		ArrayList<Card> hand = new ArrayList<>();
		ArrayList<Card> dhand = new ArrayList<>();
		deck.shuffle();
		
		//System.out.println("Would you like to play?");
		//String input = sc.next();
		hand.add(deck.dealTop());
		dhand.add(deck.dealTop());
		hand.add(deck.dealTop());
		dhand.add(deck.dealTop());
		
		while(!input.equalsIgnoreCase("quit") && !input.equalsIgnoreCase("no"))
		{
			System.out.println();
			System.out.println("Please place your bet");
			while(!sc.hasNextInt())
			{
				System.out.println("Sorry, please type a number");
				sc.next();
			}
			
			int bet = sc.nextInt();
			while(bet > StartAmount || bet < 0)
			{
				if(bet < 0)
				{
					System.out.println("You cannot bet less than 0");
					bet = sc.nextInt();
				}
				else
				{
					System.out.println("Sorry, you cannot bet more than your chip amount. Please place another bet");
					bet = sc.nextInt();
				}
			}
			System.out.println();
			System.out.println("Dealers Card: " + dhand.get(0));
			System.out.println();
			System.out.println(name + "'s Cards: " + getHand(hand));
			System.out.println("Sum is : " + getSum(hand));
			System.out.println();
			System.out.println("Would you like to hit, stay, or quit?");			
			input = sc.next();
			while(!input.trim().equalsIgnoreCase("stay") && !input.trim().equalsIgnoreCase("hit") && !input.trim().equalsIgnoreCase("quit"))
			{
				System.out.println("Sorry, Type hit, stay or quit");
				input = sc.next();
			}
			if(input.equalsIgnoreCase("quit"))
			{
				break;
			}
									
			while(input.equalsIgnoreCase("hit") && !input.equalsIgnoreCase("quit"))
			{
				if(deck.size() <= 2)
				{
					while(!deck.isEmpty())
					{
						graveyard.insertAtRandom(deck.dealTop());
					}
					holder = deck;
					deck = graveyard;
					graveyard = holder;
					deck.shuffle();
				}
				hand.add(deck.dealTop());
				System.out.println();
				System.out.println(name + "'s Cards: " + getHand(hand));
				System.out.println("Sum is : " + getSum(hand));
				if(getSum(hand) > 21)
				{
					System.out.println("You Bust!");
					break;
				}
				System.out.println("Would you like to hit, stay, or quit?");
				input = sc.next();
			}//while
			
			while(getSum(dhand) < 17)
			{
				if(deck.size() <= 2)
				{
					while(!deck.isEmpty())
					{
						graveyard.insertAtRandom(deck.dealTop());
					}
					holder = deck;
					deck = graveyard;
					graveyard = holder;
					deck.shuffle();
				}
				dhand.add(deck.dealTop());
			}

			if((getSum(dhand) > 21 && getSum(hand) <= 21) || ((getSum(hand) <= 21 && getSum(dhand) <= 21) && getSum(hand) > getSum(dhand)))
			{
				System.out.println("Dealers hand : " + getHand(dhand) + " Sum : " + getSum(dhand));
				System.out.println(name + " Wins the Hand!");
				System.out.println();
				StartAmount += 2*bet;
				System.out.println("Your chip amount : " + StartAmount);
			}
			else if((getSum(dhand) > 21) && (getSum(hand) > 21) || getSum(dhand) == 21 && getSum(hand) == 21 || getSum(hand) == getSum(dhand))
			{
				System.out.println("Its a draw! Dealer has : " + getHand(dhand) + " Sum: " + getSum(dhand));
				System.out.println();
				System.out.println("Your chip amount : " + StartAmount);
			}
			
			else if((getSum(dhand) <= 21 && getSum(hand) > 21) || ((getSum(hand) <= 21 && getSum(dhand) <= 21) && getSum(dhand) > getSum(hand)))
			{
				System.out.println();
				System.out.println("Dealer Wins with : " + getHand(dhand) + "| Sum : " + getSum(dhand));
				System.out.println();
				StartAmount -= bet;
				System.out.println("Your chip amount : " + StartAmount);
				if(StartAmount <= 0)
				{
					System.out.println("Sorry, You are out of money!");
					System.out.println("Would you like to buy-in again?");
					input = sc.next();
					while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("quit"))
					{
						System.out.println("Sorry, Please type yes or no");
						input = sc.next();
					}
					if(input.equalsIgnoreCase("yes"))
					{
						System.out.println("How much would you like to buy in for?");
						while(!sc.hasNextInt())
						{
							System.out.println("Sorry, please type in a number");
						}
						StartAmount = sc.nextInt();
						buyin = true;
					}					
				}
			}
			
			while(!hand.isEmpty())
			{
				graveyard.insertAtRandom(hand.remove(0));
			}
			while(!dhand.isEmpty())
			{
				graveyard.insertAtRandom(dhand.remove(0));
			}
			if(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("quit"))
			{
				break;
			}
			
			if(!buyin == true)
			{
				System.out.println("Would you like to play another hand?");
				input = sc.next();
			}
			if(buyin == true)
			{
				input = "yes";
			}
			
			//System.out.println("Would you like to play another hand?");
			//input = sc.next();
			
			while(!input.trim().equalsIgnoreCase("yes") && !input.trim().equalsIgnoreCase("no") && !input.trim().equalsIgnoreCase("quit"))
			{
				System.out.println("Please type yes or no");
				input = sc.next();
			}
			if(deck.size() <= 5)
			{
				while(!deck.isEmpty())
				{
					graveyard.insertAtRandom(deck.dealTop());
				}
				holder = deck;
				deck = graveyard;
				graveyard = holder;
				deck.shuffle();
			}
			hand.add(deck.dealTop());
			dhand.add(deck.dealTop());
			hand.add(deck.dealTop());
			dhand.add(deck.dealTop());
			
		}//while
		System.out.println("Goodbye!");

	}//main


	public static String getHand(ArrayList<Card> hand)
	{
		String ret = "";
		for(int i = 0; i < hand.size(); i ++)
		{
			if(i == hand.size()-1)
			{
				ret += hand.get(i);
			}
			else
			{
				ret += hand.get(i) + ", ";
			}
		}
		return ret;
	}
	
	public static int getSum(ArrayList<Card> hand)
	{
		int ret = 0;
		Card curr;
		int aces = 0;
		
		for(int i = 0; i < hand.size(); i ++)
		{
			curr = hand.get(i);
			if(curr.getVal().equalsIgnoreCase("A"))
			{
				aces += 1;
			}//if
			else
			{
				ret += Integer.parseInt((curr.getVal()));
			}//else
		}//for
		
		for(int i = 0; i < aces; i ++)
		{
			if(ret <= 10)
			{
				ret += 11;
			}//if
			else
			{
				ret += 1;
			}//else
		}//for
		
		return ret;		
	}



}
