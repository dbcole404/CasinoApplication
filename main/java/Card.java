import java.util.Arrays;
import java.util.List;

public class Card {

    private String suit;
    private static int cardNum;
    private String cardName;
    private final List<String> validSuits = Arrays.asList("HEARTS", "CLUBS", "DIAMONDS", "SPADES");

    //Card constructor
    public Card(String suit, int cardNumber) {
        setSuit(suit.toUpperCase());
        setCardNum(cardNumber);
    }

    //Check if suit is valid
    private boolean isValidSuit(String suitCheck) {
        return (validSuits.contains(suitCheck));
    }

    //Check if number value of card is valid
    private boolean isValidCardNum(int num) {
        boolean result = true;
        if (num < 1 || num > 13) {
            result = false;
        }
        return result;
    }

    //Convert number value of the card to matching string for the card's name
    private String cardNumToCardName(int num) {
        switch (num) {
            case 1  -> cardName = "ACE";
            case 2  -> cardName = "2";
            case 3  -> cardName = "3";
            case 4  -> cardName = "4";
            case 5  -> cardName = "5";
            case 6  -> cardName = "6";
            case 7  -> cardName = "7";
            case 8  -> cardName = "8";
            case 9  -> cardName = "9";
            case 10 -> cardName = "10";
            case 11 -> cardName = "JACK";
            case 12 -> cardName = "QUEEN";
            case 13 -> cardName = "KING";
            default -> cardName = "NO_CARD_NAME";
        }
        return cardName;
    }

    //Set suit
    public void setSuit(String suit){
        if (isValidSuit(suit)) {
            this.suit = suit;
        }

    }

    //Set card number
    public void setCardNum(int num){
        this.cardNum = num;
        this.cardName = cardNumToCardName(num);
    }

    //Get card suit
    public String getSuit(){
        return suit;
    }

    //Get card number value
    public static int getCardNum(){
        return cardNum;
    }

    //Get card name
    public String getCardName(){
        return cardName;
    }

    //Return card as a string
    //EX: "JACK OF HEARTS"
    public String toString() {
        return (this.cardName + " OF " + this.suit);
    }

}