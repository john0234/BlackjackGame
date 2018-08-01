public class Deck extends Card{

    private Card[] deck;

    public Deck(int numberOfDecks){

    }

    private void printDeck(){

        for(int i=0; i<deck.length; i++){

            System.out.println(deck[i].getType()+" of "+deck[i].getSuit());
        }
    }

}
