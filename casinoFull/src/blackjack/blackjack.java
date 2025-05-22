package blackjack;
import shuffle.shuffle;
import java.util.Scanner;
public class blackjack {
    public blackjack(){

    }
    public double blackjackMain(double totalCash){
        System.out.println("Current winnings: " + totalCash);
        System.out.print("How much would you like to bet? ");
        Scanner scanner = new Scanner(System.in);
        double wager = scanner.nextDouble();
        while (wager > totalCash){
            System.out.println("You do not have that much to bet");
            System.out.print("How much would you like to bet? ");
            wager = scanner.nextDouble();
        }
        totalCash = totalCash - wager;
        shuffle Shuffle = new shuffle();
        String[] cards = Shuffle.shuffle();
        
    }
}
