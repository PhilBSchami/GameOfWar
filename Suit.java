public enum Suit {

    DIAMONDS("♦"),
    HEARTS("♥"),
    CLUBS("♣"),
    SPADES("♠");

    private String suit;

    Suit(String suit){
        this.suit = suit;
    }

    public String getSuit(){
        return suit;
    }
}
