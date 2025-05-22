import java.util.Scanner;
import rideTheBus.rideTheBus;
import blackjack.blackjack;

public class Main {
    public static void main(String [] args){
        System.out.println("Welcome to the casino");
        rideTheBus rTB = new rideTheBus();
        blackjack blackjack = new blackjack();
        double winnings = 1000.00;
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        while(repeat) {
            System.out.println("What game would you like to play?");
            System.out.println("1. Ride the Bus");
            System.out.println("2: Blackjack");
            System.out.println("3: Quit");
            int toPlay = scanner.nextInt();

            if (toPlay == 1) winnings = rTB.rideTheBusMain(winnings);
            if (toPlay == 2) winnings = blackjack.blackjackMain(winnings);
            if (toPlay == 3) repeat = false;
            System.out.println("Your winnings are: $" + winnings);
        }
    }
}
