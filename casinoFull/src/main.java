import java.util.Scanner;
import rideTheBus.rideTheBus;

public class main {
    public static void main(String [] args){
        System.out.println("Welcome to the casino");
        rideTheBus rTB = new rideTheBus();
        double winnings = 1000.00;
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What game would you like to play?");
        System.out.println("1. Ride the Bus");
        System.out.println("2: Blackjack");
        int toPlay = scanner.nextInt();
        if (toPlay == 1){
            winnings = rTB.rideTheBusMain(winnings);
        }
        if (toPlay == 2){
            System.out.println("Suck My Dick");
        }
        System.out.println("Your winnings are: $" + winnings);
    }
}
