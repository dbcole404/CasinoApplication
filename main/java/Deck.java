import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    public static Card tempCard;
    private static ArrayList<Card> deck;
    private int numDecks = 1;
    private final List<String> validSuits = Arrays.asList("HEARTS", "CLUBS", "DIAMONDS", "SPADES");

    public Deck() {
        deck = new ArrayList<Card>();
        reset();
    }

    //Deck constructor for multiple decks
    public Deck(int numDecks) {
        deck = new ArrayList<Card>();
        this.numDecks = numDecks;
        reset();
    }

    //Get full name of card in deck at index i
    public String getCardString(int i) {
        return deck.get(i).toString();
    }

    //Get suit of card in deck at index i
    public static String getCardSuit(int i) {
        return deck.get(i).getSuit();
    }

    //Get number of card in deck at index i
    public static int getCardNum(int i) {
        return deck.get(i).getCardNum();
    }

    //Get number of card in deck at index i
    public String getCardName(int i) {
        return deck.get(i).getCardName();
    }

    //Get number of decks
    public int getNumDecks() { return this.numDecks; }

    //Get number of cards
    public int getNumCards() { return deck.size(); }

    //Test: See if all cards are in deck
    public void printDeck() {
        for (int i = 0; i < deck.size(); i++){
            System.out.println(getCardString(i));
        }
    }

    //Returns the first Card object in deck, and then removes it from the deck
    public static Card dealTopCard() {
        Card tempCard = new Card(getCardSuit(0), getCardNum(0));
        deck.remove(0);
        return tempCard;
    }

    //Shuffle all cards in deck
    public static void shuffle() {
        Collections.shuffle(deck);
    }

    //Reset deck/s to new deck order
    public void reset() {
        if (this.numDecks == 1) {
            reset1();
        }
        else {
            reset2(numDecks);
        }
    }

    //Called if resetting a singular deck to new deck order
    private void reset1() {
        deck.clear();

        for (String suit : validSuits) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(suit, j));
            }
        }
        this.numDecks = 1;
    }

    //Called if resetting multiple decks to new deck order
    private void reset2(int numDecks) {
        deck.clear();

        for (int i = 0; i < numDecks; i++) {
            for (String suit : validSuits) {
                for (int j = 1; j <= 13; j++) {
                    deck.add(new Card(suit, j));
                }
            }
        }
    }

}