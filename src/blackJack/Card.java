package blackJack;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String suit;
    private int cardNum;
    private int cardValue;
    private String cardName;
    private final List<String> validSuits = Arrays.asList("HEARTS", "CLUBS", "DIAMONDS", "SPADES");

    //blackJack.Card constructor
    public Card(String suit, int cardNumber) {
        setSuit(suit.toUpperCase());
        setCardNum(cardNumber);
        setValue(cardNumber);
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
            case 2  -> cardName = "TWO";
            case 3  -> cardName = "THREE";
            case 4  -> cardName = "FOUR";
            case 5  -> cardName = "FIVE";
            case 6  -> cardName = "SIX";
            case 7  -> cardName = "SEVEN";
            case 8  -> cardName = "EIGHT";
            case 9  -> cardName = "NINE";
            case 10 -> cardName = "TEN";
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
    public void setCardNum(int num) {
        this.cardNum = num;
        this.cardName = cardNumToCardName(num);
    }

    //Set card value (for blackjack)
    public void setValue(int num) {
        if (num > 1 && num <= 10) {
            this.cardValue = num;
        }
        else if (num > 10 && num <= 13){
            this.cardValue = 10;
        }
        else {
            this.cardValue = 11;
        }
    }

    //Get card suit
    public String getSuit(){
        return this.suit;
    }

    //Get card number value
    public int getNum(){
        return this.cardNum;
    }

    public int getValue() {
        return this.cardValue;
    }

    //Get card name
    public String getName(){
        return this.cardName;
    }

    //Return card as a string
    //EX: "JACK OF HEARTS"
    public String toString() {
        return (this.cardName + " OF " + this.suit);
    }
}