package shuffle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class shuffle {
    public String[] shuffle() {
        String[] cards = {"2 of Hearts", "3 of Hearts", "4 of Hearts", "5 of Hearts", "6 of Hearts", "7 of Hearts", "8 of Hearts", "9 of Hearts", "10 of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts", "Ace of Hearts",
                "2 of Diamonds", "3 of Diamonds", "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds", "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds", "Ace of Diamonds",
                "2 of Spades", "3 of Spades", "4 of Spades", "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades", "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades", "Ace of Spades",
                "2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs", "Ace of Clubs",};
        List<String> cardsList = Arrays.asList(cards);
        Collections.shuffle(cardsList);
        cardsList.toArray(cards);
        return cards;

    }
    public int cardValueRTB(String card){
        if(card.startsWith("2")){
            return 1;
        }
        if(card.startsWith("3")){
            return 2;
        }
        if(card.startsWith("4")){
            return 3;
        }
        if(card.startsWith("5")){
            return 4;
        }
        if(card.startsWith("6")){
            return 5;
        }
        if(card.startsWith("7")){
            return 6;
        }
        if(card.startsWith("8")){
            return 7;
        }
        if(card.startsWith("9")){
            return 8;
        }
        if(card.startsWith("10")){
            return 9;
        }
        if(card.startsWith("J")){
            return 10;
        }
        if(card.startsWith("Q")){
            return 11;
        }
        if(card.startsWith("K")){
            return 12;
        }
        if(card.startsWith("A")){
            return 13;
        }

        return 0;
    }
    public int cardValue(String card){
        if(card.startsWith("2")){
            return 2;
        }
        if(card.startsWith("3")){
            return 3;
        }
        if(card.startsWith("4")){
            return 4;
        }
        if(card.startsWith("5")){
            return 5;
        }
        if(card.startsWith("6")){
            return 6;
        }
        if(card.startsWith("7")){
            return 7;
        }
        if(card.startsWith("8")){
            return 8;
        }
        if(card.startsWith("9")){
            return 9;
        }
        if(card.startsWith("10")){
            return 10;
        }
        if(card.startsWith("J")){
            return 10;
        }
        if(card.startsWith("Q")){
            return 10;
        }
        if(card.startsWith("K")){
            return 10;
        }
        if(card.startsWith("A")){
            return 11;
        }

        return 0;
    }
    public int aceChecker(){

        return 11;
    }
}
