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
        }while (wager < 0){
            System.out.println("You cannot bet a negative amount of money");
            System.out.print("How much would you like to bet? ");
            wager = scanner.nextDouble();
        }
        totalCash = totalCash - wager;
        shuffle Shuffle = new shuffle();
        String[] cards = Shuffle.shuffle();
        int cardsDealt = 4;
        String newCard;
        System.out.println("Dealing Starts");
        System.out.println("You have been dealt the "+ cards[0]);
        System.out.println("Dealer has been dealt the "+ cards[1]);
        System.out.println("You have been dealt the "+ cards[2]);
        System.out.println("Dealer has been dealt a card face down");
        int playerTotal = Shuffle.cardValueblackjack(cards[0],0);
        playerTotal = Shuffle.cardValueblackjack(cards[2], playerTotal);
        int dealerTotal = Shuffle.cardValueblackjack(cards[1],0);
        dealerTotal = Shuffle.cardValueblackjack(cards[3], dealerTotal);
        System.out.println("Your total is "+ playerTotal);
        if(playerTotal == 21){
            System.out.println("Blackjack!");
            return totalCash + (wager*2);
        }
        if(dealerTotal == 21){
            System.out.println("Dealer Blackjack!");
            return totalCash;
        }
        System.out.println("Would you like to hit or stand? ");
        String answer = scanner.nextLine();
        answer = answer.toLowerCase();
        while (answer.equals("hit")){
            newCard = cards[cardsDealt];
            System.out.println("You received a " + newCard);
            cardsDealt += 1;
            playerTotal = Shuffle.cardValueblackjack(newCard, playerTotal);
            System.out.println("Your Total is " + playerTotal);
            if (playerTotal < 21){
                System.out.println("Would you like to hit or stand? ");
                answer = scanner.nextLine();
                answer = answer.toLowerCase();
            }
            if (playerTotal == 21){
                System.out.println("Blackjack!");
                return totalCash + (wager*2);
            }
            if (playerTotal > 21){
                System.out.println("Player Busts");
                return totalCash;
            }
        }
        while (dealerTotal < 17){
            newCard = cards[cardsDealt];
            System.out.println("Dealer received a " + newCard);
            cardsDealt += 1;
            dealerTotal = Shuffle.cardValueblackjack(newCard, dealerTotal);
            if(dealerTotal == 21){
                System.out.println("Dealer Blackjack!");
                return totalCash;
            }
            if (dealerTotal > 21){
                System.out.println("Dealer Busts");
                return totalCash + (wager*2);
            }
        }
        if (playerTotal > dealerTotal){
            return totalCash + (wager*2);
        }
        return totalCash;
    }
}
