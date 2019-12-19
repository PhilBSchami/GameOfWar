public class Dealer {

    private Card card;

    public void setCard(Card card) {
        this.card = card;
    }

    public int getCard(){
        return card.getCard();
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

        return "Dealer Card:\t" + cardValue;
    }
}
