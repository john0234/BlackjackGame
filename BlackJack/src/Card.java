public class Card {

    private final static String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
    private final static String[] types = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private final static int[] values = {2,3,4,5,6,7,8,9,10,10,10,10};

    private int type;
    private int suit;

    public Card(int type, int suit){
        this.type = type;
        this.suit = suit;
    }

    public String getType(){
        return types[this.type];
    }

    public String getSuit(){
        return suits[this.suit];
    }

    public int getValue(){
        return values[this.type];
    }

    public static void main(String[] args)throws Exception{
/*
        Card card = new Card(11,1);
        Card[] deck;

        System.out.println(card.getType());
        System.out.println(card.getSuit());
        System.out.println(card.getValue());

        int counter = 0;

        for(int i=0; i<4; i++) {

            for (int j = 0; j < 12; j++) {

                deck[(i*12)+j] = new Card(j,i);

            }
        }
*/

    }

}



