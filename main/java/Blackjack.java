import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Blackjack {

    private final Scanner scnr = new Scanner(System.in);
    private static int bet;
    private static ArrayList<Card> hand;
    private static ArrayList<Card> dealerHand;
    private static int value;
    private int totalChips = 1000;
    private String str;
    private boolean playerStand;
    private boolean dealerStand;

    public void createHands (){
        hand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
    }
//Asks the player to input how many of their chips they would like to bet
    public void setBet(int bet){
        System.out.println("How much would you like to bet? Minimum Buy-In is 50 chips.");
        bet = scnr.nextInt();
            if (bet > totalChips){
                System.out.println("You don't have that many chips.");
        }
            if (totalChips < 50){
                System.out.println("You don't have the funds for the minimum buy-in.");
            }
        System.out.println("Your bet has been set to " + bet + "chips.");
            beginPlay();
    }
//Initiates play; shuffles the deck, and deals two cards to player and dealer, alternating between the two.
    public void beginPlay(){
        playerStand = false;
        dealerStand = false;
        Deck.shuffle();
        Deck.dealTopCard();
        hand.add(Deck.tempCard);
        Deck.dealTopCard();
        dealerHand.add(Deck.tempCard);
        Deck.dealTopCard();
        hand.add(Deck.tempCard);
        Deck.dealTopCard();
        dealerHand.add(Deck.tempCard);
        command();
    }
//The bulk of the game, presents the player with Rules and Action effects when requested by the player, otherwise allows the player to input their choices for the game, and reacts accordingly.
    public void command() {
        System.out.println("Please select an action, the available actions are listed below:");
        System.out.println("For help as to what each Action does, enter A as your command.");
        System.out.println("To view the Rules of Blackjack, enter R as your command.");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1: Hit");
        System.out.println("2: Stand");
        System.out.println("3: Double Down");
        System.out.println(" ");
        String command = "";
        str = scnr.nextLine();
        command = str.charAt(0) + "";
        System.out.println("Current hand:" + hand);
            switch(command){
                if(playerStand){
                    str = "2";
                }
                case "1" :
                    Deck.dealTopCard();
                    hand.add(Deck.tempCard);
                    if(dealerHand.handValue < 17){
                        Deck.dealTopCard();
                        dealerHand.add(Deck.tempCard);
                    }
                    if(hand.handValue > 21){
                        playerStand = true;
                    }
                    if(dealerStand && playerStand){
                        compareHands();
                    }
                    command();

                case "2":
                    playerStand = true;
                    if(dealerHand.handValue < 17){
                        Deck.dealTopCard();
                        dealerHand.add(Deck.tempCard);
                        }
                    else{
                        dealerStand = true;
                    }
                    if(playerStand && dealerStand){
                        compareHands();
                    }
                    command();

                case "3":
                    bet = (bet * 2);
                    Deck.dealTopCard();
                    hand.add(Deck.tempCard);
                    playerStand = true;
                    if(dealerHand.handValue < 17){
                        Deck.dealTopCard();
                        dealerHand.add(Deck.tempCard);
                    }
                    else{
                        dealerStand = true;
                    }
                    if(playerStand && dealerStand) {
                        compareHands();
                    }

                case "A":
                    System.out.println("Hit: This command will call another card into your hand");
                    System.out.println("Stand: This command will lock your hand in its' current state, preventing any cards from being added for the remainder of the round.");
                    System.out.println("Double Down: This command will double your current bet, and will draw one card to your hand. Following this draw, you will stand for the remainder of the round.");

                case "R":
                    System.out.println("Breakdown and Card Values: Blackjack is a card game where the goal is to get the value of the hand as close to 21 as possible, without busting (going over). Number cards have the value of their own number," +
                            "while face cards (Jack, King, and Queen all have the value of 10. The Ace card will carry the value of 11, unless the holder of an ace busts, in which case" +
                            "the Ace will change to a value of 1, lowering the hands' value back below 21.");
                    System.out.println("Initial Dealing: The game will start with the dealer giving the player and themselves two cards each, should either of them" +
                            "begin a round with an Ace and a card with the value of 10, they automatically win that round with a Blackjack.");
                    System.out.println("Round Play: After the initial deal, the player acts first, and may Hit, Stand, or Double Down," +
                            " after which the dealer will either Hit or Stand, continuing in a cycle from there until both players have Stood or gone Bust.");
                    System.out.println("Ending a Round: Once both players have either Stood or gone Bust, the round will end and their hands will be compared, should either the player or dealer have gone bust," +
                            " the other hand automatically wins. If both players went bust, neither wins and the players bet is still lost. In the event of a tie, also known as a Push, the players" +
                            " bet is returned to them, with no losses and a new round begins. In the absence of these possibilities, the hands are simply compared, and the value closest to 21 wins");
                    System.out.println("Winnings: Winning a round with any standard hand will return the players bet, along with winnings equal to that bet (bet: 50, returned: 100, winnings: 50)." +
                            " Should a player win with a Blackjack, they're bet will be returned with their winnings totalling their bet * 1.5 (bet: 50, returned: 125, winnings: 75.");
                default:
                    System.out.println("Please enter a valid command");

            }



//used to determine the value of the hand when requested.
    }
    public int handValue(){
        int value = 0;
        for(int i = 0; i < hand.size(); i++){
            value + Card.getCardNum(i);
        }
        return value;
    }

    private void compareHands() {
        if(hand.handValue > 21){
            System.out.println("Sorry, you went bust, better luck next round.");
            beginPlay();
        }
        if(hand.handValue <= 21 && dealerHand.handValue > 21){
            System.out.println("Looks like I bust, you win this round.");
            beginPlay();
        }
        if(hand.handValue <= 21 && dealerHand.handValue <= 21){
            if(hand.handValue < dealerHand.handValue){
                System.out.println("Sorry, looks like I win this one.");
                beginPlay();
            }
        }
        if(hand.handValue <= 21 && dealerHand.handValue <= 21){
            if(hand.handValue > dealerHand.handValue){
                System.out.println("You win this hand, enjoy the winnings.");
                beginPlay();
            }
        }
        if(hand.handValue <= 21 && dealerHand.handValue <= 21){
            if(hand.handValue == dealerHand.handValue){
                System.out.println("Looks like we have a push, here's your bet back.");
                beginPlay();
            }
        }

    }


    public static void main(String[] args){

    }



}
