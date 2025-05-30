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
        double splitWager = wager;
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
        blackjackHand playerHand1 = new blackjackHand();
        blackjackHand playerHand2 = new blackjackHand();
        blackjackHand playerHand = new blackjackHand();
        blackjackHand dealerHand = new blackjackHand();
        dealerHand.exists = true;
        String newCard;
        System.out.println("Dealing Starts");
        System.out.println("You have been dealt the "+ cards[0]);
        System.out.println("Dealer has been dealt the "+ cards[1]);
        System.out.println("You have been dealt the "+ cards[2]);
        System.out.println("Dealer has been dealt a card face down");

        int playerCard1 = Shuffle.cardValue(cards[0]);
        int playerCard2 = Shuffle.cardValue(cards[2]);
        if (playerCard1 == playerCard2){
            System.out.println("Would you like to split? ");
            System.out.println("Splitting requires doubling the bet");
            String split = scanner.nextLine();
            split = split.toLowerCase();
            if (split.contains("yes") || split.contains("y")){
                playerHand1.newHandSplit(playerCard1);
                playerHand1.exists = true;
                playerHand2.newHandSplit(playerCard2);
                playerHand2.exists = true;
                if(playerCard1 == 11){
                    playerHand1.aceCheck += 1;
                    playerHand2.aceCheck += 2;
                }

            }
            else{
                playerHand.newHand(playerCard1, playerCard2);
                playerHand.exists = true;
                if(playerCard1 == 11){
                    playerHand.aceCheck +=2;
                }
            }
        }
        else{
            playerHand.newHand(playerCard1, playerCard2);
            playerHand.exists = true;
            if ((playerCard1 == 11) || (playerCard2 == 11)){
                playerHand.aceCheck += 1;
            }
        }

        dealerHand.newHand(Shuffle.cardValue(cards[1]),Shuffle.cardValue(cards[3]) );
        if(playerHand.handTotal > 21){  //Dealt two Ace handling
            playerHand.handTotal = 12;
            dealerHand.aceCheck -= 1;
        }
        if(dealerHand.handTotal > 21) {
            dealerHand.handTotal = 12;
            dealerHand.aceCheck -= 1;
        }
        if (playerHand.exists){
            System.out.println("Your total is "+ playerHand.handTotal);
        }

        if(playerHand.handTotal == 21){
            if(playerHand.handTotal == dealerHand.handTotal){
                System.out.println("Double blackjack");
                System.out.println("Tie!");
                return totalCash + wager;
            }
            System.out.println("Blackjack!");
            return totalCash + (wager*2);
        }
        if(dealerHand.handTotal == 21){
            System.out.println("Dealer's hidden card was "+ cards[3]);
            System.out.println("Dealer Blackjack!");
            return totalCash;
        }


        if (playerHand.exists) {
            System.out.println("Would you like to hit or stand? ");
            String answer = scanner.nextLine();
            answer = answer.toLowerCase();
            while (answer.equals("hit")) {  //Player Hit Loop
                newCard = cards[cardsDealt];
                System.out.println("You received a " + newCard);
                if (Shuffle.cardValue(newCard) == 11) {
                    playerHand.aceCheck += 1;
                }
                playerHand.handHit(Shuffle.cardValue(newCard));
                if (playerHand.handTotal > 21 && playerHand.aceCheck > 0) {  // If ace takes player over 21, make it 1 not 11
                    playerHand.handTotal -= 10;
                    playerHand.aceCheck -= 1;
                    System.out.println("Your Ace has been changed from 11 to 1");
                }
                cardsDealt += 1;
                System.out.println("Your Total is " + playerHand.handTotal);
                if (playerHand.handTotal < 21) {
                    System.out.println("Would you like to hit or stand? ");
                    answer = scanner.nextLine();
                    answer = answer.toLowerCase();
                }
                if (playerHand.handTotal == 21) {
                    System.out.println("Blackjack!");
                    return totalCash + (wager * 2);
                }
                if (playerHand.handTotal > 21) {
                    System.out.println("Player Busts");
                    return totalCash;
                }
            }
        }
        if(playerHand1.exists){
            System.out.println("You are now playing with the first hand");
            System.out.println("As a reminder, the card is " + cards[0]);
            System.out.println("Would you like to hit or stand? ");
            String answer = scanner.nextLine();
            answer = answer.toLowerCase();
        }
        System.out.println("The dealers hidden card was "+ cards[3] + ", bringing the dealer's total to " + dealerTotal);
        while (dealerTotal < 17){
            newCard = cards[cardsDealt];
            dealerTotal = Shuffle.cardValue(newCard) + dealerTotal;
            System.out.println("Dealer received a " + newCard + ", bringing the dealer's total to "+ dealerTotal);
            if (Shuffle.cardValue(newCard) == 11){
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
        if (playerTotal == dealerTotal){
            System.out.println("Tie game");
            return totalCash + wager;
        }
        System.out.println("This is more than your total, the dealer wins");
        return totalCash;
    }
    public void blackjackHand(int card1, int card2){
        int value;
        if (card2 == 0){
            value = card1;
        }
        else{
            value = card1+card2;
        }

    }


}
