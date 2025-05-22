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
        while (wager < 0){
            System.out.println("You cannot bet a negative amount of money");
            System.out.print("How much would you like to bet? ");
            wager = scanner.nextDouble();
        }
        totalCash = totalCash - wager;
        scanner.nextLine();
        shuffle Shuffle = new shuffle();
        String[] cards = Shuffle.shuffle();
        int cardsDealt = 4;
        int aceCheckPlayer = 0;
        int aceCheckDealer = 0;
        String newCard;
        System.out.println("Dealing Starts");
        System.out.println("You have been dealt the "+ cards[0]);
        System.out.println("Dealer has been dealt the "+ cards[1]);
        System.out.println("You have been dealt the "+ cards[2]);
        System.out.println("Dealer has been dealt a card face down");
        if (Shuffle.cardValueblackjack(cards[0]) == 11){
            aceCheckPlayer += 1;
        }
        if (Shuffle.cardValueblackjack(cards[2]) == 11){
            aceCheckPlayer += 1;
        }
        if (Shuffle.cardValueblackjack(cards[1]) == 11){
            aceCheckDealer += 1;
        }
        if (Shuffle.cardValueblackjack(cards[3]) == 11){
            aceCheckDealer += 1;
        }
        int playerTotal = Shuffle.cardValueblackjack(cards[0]);
        playerTotal = Shuffle.cardValueblackjack(cards[2]) + playerTotal;
        int dealerTotal = Shuffle.cardValueblackjack(cards[1]);
        dealerTotal = Shuffle.cardValueblackjack(cards[3]) + dealerTotal;
        if(playerTotal > 21){  //Dealt two Ace handling
            playerTotal = 12;
            aceCheckPlayer -= 1;
        }
        if(dealerTotal > 21) {
            dealerTotal = 12;
            aceCheckDealer -= 1;
        }
        System.out.println("Your total is "+ playerTotal);
        if(playerTotal == 21){
            System.out.println("Blackjack!");
            return totalCash + (wager*2);
        }
        if(dealerTotal == 21){
            System.out.println("Dealer's hidden card was "+ cards[3]);
            System.out.println("Dealer Blackjack!");
            return totalCash;
        }
        System.out.println("Would you like to hit or stand? ");
        String answer = scanner.nextLine();
        answer = answer.toLowerCase();
        while (answer.equals("hit")){  //Player Hit Loop
            newCard = cards[cardsDealt];
            System.out.println("You received a " + newCard);
            if (Shuffle.cardValueblackjack(newCard) == 11){
                aceCheckPlayer +=1;
            }
            playerTotal = Shuffle.cardValueblackjack(newCard) + playerTotal;
            if (playerTotal > 21 && aceCheckPlayer > 0){  // If ace takes player over 21, make it 1 not 11
                playerTotal -= 10;
                aceCheckPlayer -= 1;
                System.out.println("Your Ace has been changed from 11 to 1");
            }
            cardsDealt += 1;
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
        System.out.println("The dealers hidden card was "+ cards[3] + ", bringing the dealer's total to " + dealerTotal);
        while (dealerTotal < 17){
            newCard = cards[cardsDealt];
            dealerTotal = Shuffle.cardValueblackjack(newCard) + dealerTotal;
            System.out.println("Dealer received a " + newCard + ", bringing the dealer's total to "+ dealerTotal);
            if (Shuffle.cardValueblackjack(newCard) == 11){
                aceCheckDealer +=1;
                }
            cardsDealt += 1;
            if (dealerTotal > 21 && aceCheckDealer > 0){
                dealerTotal -= 10;
                aceCheckPlayer -= 1;
                System.out.println("The dealer's Ace has been changed from 11 to 1, bringing the dealer's total to " + dealerTotal);
                }

            if(dealerTotal == 21){
                System.out.println("Dealer Blackjack!");
                return totalCash;
            }
            if (dealerTotal > 21){
                System.out.println("Dealer Busts");
                return totalCash + (wager*2);
            }
        }
        System.out.println("The dealer's total is " + dealerTotal);
        if (playerTotal > dealerTotal){
            System.out.println("This is less than your total, congratulations");
            return totalCash + (wager*2);
        }
        System.out.println("This is more than your total, the dealer wins");
        return totalCash;
    }
}
