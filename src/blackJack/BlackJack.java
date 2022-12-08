package blackJack;

import java.util.ArrayList;

public class BlackJack {
    private int totalChips = 1000;
    private int bet = 50;
    private static ArrayList<Card> hand = new ArrayList<Card>();
    private static ArrayList<Card> dealerHand = new ArrayList<Card>();
    private Deck deck = new Deck(5);
    private boolean firstTurn = true;
    private boolean endHand = true;
    private int doubleDown = 1;
    private int playerHandValue = 0;
    private int dealerHandValue = 0;
    private String result = "";

    public int getChips() {return totalChips;}
    public ArrayList<Card> getDealerHand() {return dealerHand;}
    public ArrayList<Card> getPlayerHand() {return hand;}
    public int getPlayerHandValue() {return playerHandValue;}
    public int getDealerHandValue() {return dealerHandValue;}
    public boolean isFirstTurn() {return firstTurn;}
    public boolean isEndHand() {return endHand;}
    public String getResult() {return result;}

    public BlackJack() {

    }

    public void newGame() {
        firstTurn = true;
        endHand = false;
        doubleDown = 1;
        result = "";
        totalChips -= bet;
        hand.clear();
        dealerHand.clear();
        playerHandValue = 0;
        dealerHandValue = 0;
        hand.add(deck.dealTopCard());
        dealerHand.add(deck.dealTopCard());
        hand.add(deck.dealTopCard());
        dealerHand.add(deck.dealTopCard());
        playerHandValue = handValue(hand);
        dealerHandValue = handValue(dealerHand);
    }

    public void hit() {
        hand.add(deck.dealTopCard());
        playerHandValue = handValue(hand);
        firstTurn = false;
    }

    public void stand() {
        dealerTurn();
        compareHands();
        endHand = true;
    }

    public void doubleDown() {
        totalChips -= bet;
        doubleDown = 2;
        hit();
        dealerTurn();
        compareHands();
        endHand = true;
    }

    private void dealerTurn() {
        while (handValue(dealerHand) < 17) {
            dealerHand.add(deck.dealTopCard());
        }
    }

    private void compareHands() {
        if(handValue(hand) > 21){
            result = "Sorry, you went bust, better luck next round";
        }
        if(handValue(hand) <= 21 && handValue(dealerHand) > 21){
            totalChips += (bet * 2 * doubleDown);
            result = "Looks like I bust, you win this round";
        }
        if(handValue(hand) <= 21 && handValue(dealerHand) <= 21){
            if(handValue(hand) < handValue(dealerHand)){
                result = "Sorry, looks like I win this one";
            }
        }
        if(handValue(hand) <= 21 && handValue(dealerHand) <= 21){
            if(handValue(hand) > handValue(dealerHand)){
                totalChips += (bet * 2 * doubleDown);
                result = "You win this hand, enjoy the winnings";
            }
        }
        if(handValue(hand) <= 21 && handValue(dealerHand) <= 21){
            if(handValue(hand) == handValue(dealerHand)){
                totalChips += bet;
                result = "Looks like we have a push, here's your bet back";
            }
        }
    }

    public int handValue(ArrayList<Card> hand) {
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total;
    }

    public String toString(ArrayList<Card> hand) {
        String temp = "<html>";
        for(Card card : hand) {
            temp += (card.toString() + "<br/>");
        }
        temp += "</html>";

        return temp;
    }

    public String dealerToString(ArrayList<Card> hand) {
        if (!endHand) {
            return "<html>" + hand.get(0).toString() + "<br/>???" + "</html>" ;
        } else {
            return toString(hand);
        }
    }

    public void newDeck() {
        deck.reset();
        deck.shuffle();
    }

    public boolean isBust(ArrayList<Card> hand) {
        return handValue(hand) > 21;
    }
}