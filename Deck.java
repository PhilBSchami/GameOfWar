import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> deck;

    Deck(){
        deck = new Stack<>();
        for(Suit suit: Suit.values()){
            for(Card card: Card.values()){
                deck.push(card);
            }
        }

        Collections.shuffle(deck);
    }

    public Card dealCard(){
        return deck.pop();
    }

    /** Used when deck runs out mid hand with cards left on table **/
    public void removeCard(int card){
        deck.remove(card);
    }

    /** Returns the amount of cards left in the deck **/
    public int getSize(){
        return deck.size();
    }

}
