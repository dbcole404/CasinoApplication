package blackJack;

import blackJack.BlackJack;

public class Main {

    public static void main(String[] args) {

        BlackJack bj = new BlackJack();

        bj.newGame();
        System.out.println(bj.toString(bj.getDealerHand()));

    }

}
