package rideTheBus;
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
        int firstCardValue = Shuffle.cardValueRTB(cards[0]);
        int secondCardValue = Shuffle.cardValueRTB(cards[1]);
        int thirdCardValue = Shuffle.cardValueRTB(cards[2]);
        System.out.print("Which colour? ");
        scanner.nextLine();
        String answer = scanner.nextLine();
        answer = answer.toLowerCase();
        System.out.println(cards[0]);
        if (colourCheck(answer,cards[0])) {
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
                if (higherLowerCheck(answer, firstCardValue, secondCardValue)) {
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
                        if (inoutCheck(answer, firstCardValue, secondCardValue, thirdCardValue)) {
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
                                if(suitCheck(answer, cards[3])) {
                                    System.out.println("Correct");
                                    System.out.println("Winnings are now 4 times the bet");
                                    wager = wager * 4;
                                    return totalCash + wager;
                                }
                                else{
                                    System.out.println("Sorry, you guessed wrong");
                                    return totalCash;
                                }
                            }
                            else{
                                wager = wager * 2;
                                return totalCash + wager;

                            }


                        }
                        else {
                            System.out.println("Sorry, you guessed wrong");
                            return totalCash;
                        }

                    }
                    else{
                        wager = wager * 2;
                        return totalCash + wager;
                    }
                }
                else{
                    System.out.println("Sorry, you guessed wrong");
                    return totalCash;
                }
            }


            else{
                return totalCash;
            }
        }
        System.out.println("Sorry, you guessed wrong");
        return totalCash;
    }
    public boolean colourCheck(String choice, String card) {
        if (choice.equals("red")) {
            return (card.contains("Hearts")) || (card.contains("Diamonds"));
        } else if (choice.equals("black")) {
            return (card.contains("Clubs")) || (card.contains("Spades"));
        }
        return false;
    }

    public boolean higherLowerCheck(String choice, int oldCard, int newCard) {
        if (choice.equals("higher")) {
            return newCard > oldCard;
        }
        if (choice.equals("lower")) {
            return newCard < oldCard;

        }
        return false;
    }
    public boolean inoutCheck(String choice, int oldestCard,int oldCard, int newCard){
        if (choice.equals("in")){
            if(oldestCard<oldCard){
                if((oldestCard<newCard)&&(newCard<oldCard)){
                    return true;
                }
            }
            else if(oldestCard>oldCard){
                if((oldestCard>newCard)&&(newCard>oldCard)){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        if (choice.equals("out")){
            if(oldestCard<oldCard){
                return (oldestCard > newCard) || (newCard > oldCard);
            }
            else if(oldestCard>oldCard){
                return (oldestCard < newCard) || (newCard < oldCard);
            }
            else{
                return false;
            }
        }
        return false;
    }
    public boolean suitCheck(String choice, String newCard){
        if ((choice.equals("hearts"))&&(newCard.contains("Hearts"))){
            return true;
        } else if ((choice.equals("diamonds"))&&(newCard.contains("Diamonds"))){
            return true;
        } else if ((choice.equals("clubs"))&&(newCard.contains("Clubs"))){
            return true;
        } else if ((choice.equals("spades"))&&(newCard.contains("Spades"))){
            return true;
        }else {
            return false;
        }
    }


}
