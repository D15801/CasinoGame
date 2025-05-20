package rideTheBus;
import rtbModes.rtbModes;
import shuffle.shuffle;
import java.util.Scanner;
public class rideTheBus {
    public rideTheBus(){
    }

    public double rideTheBusMain(double totalCash) {
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
        rtbModes game = new rtbModes();
        int firstCardValue = Shuffle.cardValueRTB(cards[0]);
        int secondCardValue = Shuffle.cardValueRTB(cards[1]);
        int thirdCardValue = Shuffle.cardValueRTB(cards[2]);
        System.out.print("Which colour? ");
        String answer = scanner.nextLine();
        answer = answer.toLowerCase();
        System.out.println(cards[0]);
        if (game.colourCheck(answer,cards[0])) {
            System.out.println("Correct");
            System.out.println("Winning are now 1 times the bet");
            System.out.print("Would you like to continue? ");
            answer = scanner.nextLine();
            answer = answer.toLowerCase();
            if((answer.equals("yes")) || (answer.equals("y"))){
                System.out.print("Higher or Lower? ");
                answer = scanner.nextLine();
                answer = answer.toLowerCase();
                System.out.println(cards[1]);
                if (game.higherLowerCheck(answer, firstCardValue, secondCardValue)) {
                    System.out.println("Correct!");
                    System.out.println("Winning are now 2 times the bet");
                    System.out.print("Would you like to continue? ");
                    answer = scanner.nextLine();
                    answer = answer.toLowerCase();
                    if ((answer.equals("yes")) || (answer.equals("y"))) {
                        System.out.print("In or out: ");
                        answer = scanner.nextLine();
                        answer = answer.toLowerCase();
                        System.out.println(cards[2]);
                        if (game.inoutCheck(answer, firstCardValue, secondCardValue, thirdCardValue)) {
                            System.out.println("Correct!");
                            System.out.println("Winnings are now 3 times the bet");
                            System.out.print("Would you like to continue? ");
                            answer = scanner.nextLine();
                            answer = answer.toLowerCase();
                            if ((answer.equals("yes")) || (answer.equals("y"))) {
                                System.out.print("Guess the suit ");
                                answer = scanner.nextLine();
                                answer = answer.toLowerCase();
                                System.out.println(cards[3]);
                                if(game.suitCheck(answer, cards[3])) {
                                    System.out.println("Correct");
                                    System.out.println("Winnings are now 4 times the bet");
                                }
                                else{
                                    return totalCash;
                                }
                            }
                            else{
                                wager = wager * 2;
                                return totalCash + wager;

                            }


                        }
                        else {
                            return totalCash;
                        }

                    }
                    else{
                        wager = wager * 2;
                        return totalCash + wager;
                    }
                }
                else{
                    return totalCash;
                }
            }


            else{
                return totalCash;
            }
        }

        return totalCash;
    }


}
