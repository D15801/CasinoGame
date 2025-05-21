import java.util.Scanner;

public class main {
    public static void main(String [] args){
        System.out.println("Welcome to the casino");
        double winnings = 1000.00;
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What game would you like to play?");
        System.out.println("1. Ride the Bus");
        int toPlay = scanner.nextInt();
        if (toPlay == 1){
            winnings = rideTheBus(winnings);
        }
    }
}
