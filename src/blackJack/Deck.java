package blackJack;

import blackJack.Card;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    private ArrayList<Card> deck;
    private int numDecks = 1;
    private final List<String> validSuits = Arrays.asList("HEARTS", "CLUBS", "DIAMONDS", "SPADES");

    public Deck() {
        deck = new ArrayList<Card>();
        reset();
    }

    //blackJack.Deck constructor for multiple decks
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
    public String getCardSuit(int i) {
        return deck.get(i).getSuit();
    }

    //Get number of card in deck at index i
    public int getCardNum(int i) {
        return deck.get(i).getNum();
    }

    //Get number of card in deck at index i
    public String getCardName(int i) {
        return deck.get(i).getName();
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

    //Returns the first blackJack.Card object in deck, and then removes it from the deck
    public Card dealTopCard() {
        Card tempCard = new Card(getCardSuit(0), getCardNum(0));
        deck.remove(0);
        return tempCard;
    }

    //Shuffle all cards in deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

    //Reset deck/s to new deck order
    public void reset() {
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
