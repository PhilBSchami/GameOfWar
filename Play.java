import java.util.Scanner;

public class Play {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        boolean cashOut = false;
        Table table = new Table();

        System.out.println("Welcome to Game of War, here is your staring balance! -> $500\n(Enter a bet of 0 to cash out)");

        do{
            System.out.println("\n*********************************************************************");
            int bet = table.placeBet(input);
            if(bet == 1){
                table.dealCards();
                table.evaluateCards(input);
            } else if(bet == 0)
                cashOut = true;

            if(table.checkBalance() == 0)
                cashOut = true;

        } while(!cashOut);

        System.out.println("\nHave a good day!");

    }
}


//Keep Playing will be replaced by a exit button in GUI that will indicate the cashout amount.