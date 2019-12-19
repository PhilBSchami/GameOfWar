import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private Card card;
    private int balance;
    private int bet;

    public void setCard(Card card){
        this.card = card;
    }

    public int getCard(){
        return card.getCard();
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBet(int bet){
        this.bet = bet;
    }

    public int getBet(){
        return bet;
    }

    public boolean hasCard(){
        if(this.card != null)
            return false;
        return true;
    }

    public String showCard(){
        String cardValue;
        if(card.getCard() == 11)
            cardValue = "J";
        else if(card.getCard() == 12)
            cardValue = "Q";
        else if(card.getCard() == 13)
            cardValue = "K";
        else if(card.getCard() == 14)
            cardValue = "A";
        else
            cardValue = Integer.toString(card.getCard());

        return "Player Card:\t" + cardValue;
    }
}
