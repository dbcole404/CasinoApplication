package blackJack;
import blackJack.InvalidOperation;
import blackJack.BlackJack;
import blackJack.Card;
import blackJack.Deck;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BlackJackTest {
    BlackJack b= new BlackJack();
    Deck d = new Deck();
    //Test for negative user hand
    @Test
    void negativeUserHand() throws InvalidOperation{
    if(b.getPlayerHandValue() == -1){
        throw new InvalidOperation("User hand value cannot be negative");
    }
    }
    @Test
    void nullUserHand() throws InvalidOperation{
        if(b.getPlayerHand() == null){
            throw new InvalidOperation("User Hand cannot be empty");
        }
    }
    @Test
    void negativeDealHand() throws InvalidOperation {
        if (b.getDealerHandValue() == -1) {
            throw new InvalidOperation("Dealer hand value cannot be negative");
        }
    }
    @Test
    void nullDealHand() throws InvalidOperation{
        if(b.getDealerHand() == null){
            throw new InvalidOperation("User Hand cannot be empty");
        }
    }
    @Test
    void nullDealCard() throws InvalidOperation{
        if(d.dealTopCard() == null){
            throw new InvalidOperation("Top card cannot be null");
        }
    }
    @Test
    void nullHandValue() throws InvalidOperation{

    }
    @Test
    void nullCardStr() throws InvalidOperation{
        int testCard = 0;
        if(testCard <= 0) {
            if (d.getCardString(testCard) == null) {
                throw new InvalidOperation("Card value cannot be negative");
            }
        }
    }
    @Test
    void negAndZeroCardNum() throws InvalidOperation{
        int testCard = 0;
        if(testCard <= 0) {
            if (d.getCardNum(testCard) <= 0) {
                throw new InvalidOperation("Card value cannot be negative");
            }
        }
    }
    @Test
    void highCardCardNum() throws InvalidOperation{
        int testCard = 14;
        if(testCard >= 14) {
            if (d.getCardNum(testCard) >= 14) {
                throw new InvalidOperation("Card String cannot above 13");
            }
        }
    }
    @Test
    void getChipsNeg() throws InvalidOperation{
        if(b.getChips() <= 0){
            throw new InvalidOperation("Cannot have negative chips");
        }
    }
    @Test
    void isFirstTurn() throws InvalidOperation{
        b.newGame();
        if(b.isFirstTurn()== false);
            throw new InvalidOperation("New game should register first turn");
        }

    @Test
    void getResultNull() throws InvalidOperation{
        if(b.getResult().equals(null)){
            throw new InvalidOperation("Result cannot be null");
        }
        if(!b.getResult().equals("Sorry, you went bust, better luck next round") ||
           !b.getResult().equals("Looks like I bust, you win this round") ||
           !b.getResult().equals("Sorry, looks like I win this one") ||
           !b.getResult().equals("You win this hand, enjoy the winnings") ||
           !b.getResult().equals("Looks like we have a push, here's your bet back")) {
            throw new InvalidOperation("Unexpected result output");
        }
    }

    @Test
    void newGame() throws InvalidOperation {
        b.isFirstTurn();
        if (b.getPlayerHandValue() >= 21 || b.getDealerHandValue() >= 21) {
            throw new InvalidOperation("The first hand cannot be 21 or above");
        }
        if (b.getPlayerHandValue() <= 0 || b.getDealerHandValue() <= 0) {
            throw new InvalidOperation("The first hand cannot be 0 or negative");
        }
    }

    @Test
    void hit() throws InvalidOperation{
        b.hit();
        if(b.isFirstTurn() == true){
            throw new InvalidOperation("First turn cannot be a hit");
        }
        if(b.getPlayerHandValue() != b.handValue(b.getPlayerHand())){
            throw new InvalidOperation("Player hand value should match");
        }
    }
    @Test
    void dealTop() throws InvalidOperation {
        assertThat(d.remove(0)), is
    }

    @Test
    void stand() throws InvalidOperation{
        if(b.getDealerHandValue() != b.getDealerHandValue() + d.dealTopCard() );
    }

    @Test
    void doubleDown() throws InvalidOperation {
        if(b.doubleDown() != 2);
    }

    @Test
    void handValue() throws InvalidOperation {
        if(b.
    }

    @Test
    void testToString() throws InvalidOperation{

    }

    @Test
    void dealerToString() throws InvalidOperation{
    }

    @Test
    void newDeck() throws InvalidOperation {
        b.isEndHand();
        if(d. == b.)

        }

    }

    @Test
    void isBust() throws InvalidOperation{

    }
}

