import java.util.Scanner;

public class Table {

    private Dealer dealer;
    private Player player;
    private Deck deck;

    Table(){
        dealer = new Dealer();
        player = new Player();
        deck = new Deck();
        player.setBalance(500);
    }


    public int placeBet(Scanner input){
        System.out.print("Enter bet: ");
        if(input.hasNextInt()){
            int bet = input.nextInt();
            if(bet == 0){
                System.out.println("You have cashed out with: $" + player.getBalance());
                return 0;
            } else if(bet <= player.getBalance()){
                player.setBet(bet);
                return 1;
            } else {
                System.out.println("Insufficient Funds.");
            }
        } else {
            System.out.println("Invalid Entry, Numbers only.");
            input.next();   //Clears Buffer
        }
        return -1;
    }


    public void dealCards(){
        player.setCard(deck.dealCard());
        System.out.println(player.showCard());
        if(isDeckEmpty())
            shuffleDeck();

        dealer.setCard(deck.dealCard());
        System.out.println(dealer.showCard());
        if(isDeckEmpty())
            shuffleDeck();
    }


    public void evaluateCards(Scanner input){
        if(player.getCard() > dealer.getCard())
            playerWon();

        else if(player.getCard() < dealer.getCard())
            playerLost();

        else {
            doubleUp(input);
        }
    }

    public void doubleUp(Scanner input){
        String choice;
        System.out.print("DRAW\nDouble Up?: [Y] Yes or [N] No: ");
        if(input.hasNext()){
            choice = input.next();
            if(choice.equalsIgnoreCase("Y")){
                player.setBet(player.getBet() * 2);
                dealCards();
                evaluateCards(input);
            } else if(choice.equalsIgnoreCase("N")){
                playerLost();
            }
        } else {
            input.next();   //Clears Buffer
        }

    }


    public void playerWon(){
        player.setBalance(player.getBalance() + player.getBet());
        System.out.println("YOU WON $" + player.getBet() + "!\nNew Balance: " + player.getBalance());
    }


    public void playerLost(){
        player.setBalance(player.getBalance() - player.getBet());
        System.out.println("YOU LOST $" + player.getBet() + "\nNew Balance: " + player.getBalance());
    }


    public int checkBalance(){
        return player.getBalance();
    }


    public boolean isDeckEmpty(){
        if(deck.getSize() == 0)
            return true;
        return false;
    }


    public boolean keepPlaying(Scanner input){
        boolean decided = false;
        do{
            System.out.print("Keep Playing? [Y] Yes or [N] No: ");
            if(input.hasNext()){
                String decision = input.next();
                if(decision.equalsIgnoreCase("Y")){
                    return true;
                } else if(decision.equalsIgnoreCase("N")){
                    return false;
                } else{
                    System.out.println("Invalid Entry.");
                    decided = false;
                }
            } else {
                input.next();   //Clears Buffer
            }
        } while(!decided);
        return true;
    }


    public void shuffleDeck(){
        System.out.println("Shuffling Deck...");
        deck = new Deck();
        //Checks if the player and dealer have cards, if so those cards are removed from the shuffled deck.
        if(player.hasCard())
            deck.removeCard(player.getCard());
        if(dealer.hasCard())
            deck.removeCard(player.getCard());
    }

}
