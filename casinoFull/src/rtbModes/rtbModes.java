package rtbModes;

public class rtbModes {

    public rtbModes() {

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

