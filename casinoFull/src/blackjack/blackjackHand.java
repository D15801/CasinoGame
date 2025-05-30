package blackjack;

public class blackjackHand {
    int handTotal = 0;
    boolean exists = false;
    int aceCheck = 0;
    public void newHand(int card1, int card2){
        handTotal = card1 + card2;
    }
    public void newHandSplit(int card1){
        handTotal = card1;
    }
    public void handHit(int newCard){
        handTotal += newCard;
    }

}

