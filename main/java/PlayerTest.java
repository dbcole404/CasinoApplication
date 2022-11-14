import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    Player player = new Player();

    @Test
    void nullUserName() throws InvalidOperation {
        player.setUserName(null);
        if (player.getUserName().equals(null)) {
            throw new InvalidOperation("Username cannot be null");
        }
    }

    @Test
    void emptyUserName() throws InvalidOperation {
        player.setUserName("");
        if (player.getUserName().equals("")) {
            throw new InvalidOperation("Username cannot be empty");
        }
    }

    @Test
    void lengthUserName() throws InvalidOperation {
        player.setUserName("Test");
        if (player.getUserName().length() <= 5) {
            throw new InvalidOperation("Username cannot be under 6 characters");
        }
    }

    @Test
    void longUserName() throws InvalidOperation {
        player.setUserName("123456789101112131415161718192021222324252627282930");
        if (player.getUserName().length() >= 30) {
            throw new InvalidOperation("Username cannot be over 30 characters");
        }
    }

    @Test
    void shortPassword() throws InvalidOperation {
        player.setPassWord("TestPas");
        if (player.getPassWord().length() <= 7) {
            throw new InvalidOperation("Password has to be 8 characters");
        }
    }

    @Test
    void nullPassword() throws InvalidOperation {
        player.setPassWord(null);
        if (player.getPassWord() == null) {
            throw new InvalidOperation("Password cannot be null.");
        }
    }

    @Test
    void emptyPassword() throws InvalidOperation {
        player.setPassWord("");
        if (player.getPassWord().equals("")) {
            throw new InvalidOperation("Password cannot be empty.");
        }
    }

    @Test
    void chipsNeg() throws InvalidOperation {
        player.setChips(-1);
        if (player.getChips() < 0) {
            throw new InvalidOperation("Chips cannot go below 0");
        }
    }

    @Test
    void moneyNeg() throws InvalidOperation {
        player.setMoney(-1);
        if (player.getMoney() < 0) {
            throw new InvalidOperation("Money cannot go below 0");
        }
    }

    @Test
    void winsNeg() throws InvalidOperation {
        player.setWins(-1);
        if (player.getWins() < 0) {
            throw new InvalidOperation("Wins cannot go below 0");
        }
    }
    
    @Test
    void lossNeg() throws InvalidOperation {
        player.setLosses(-1);
        if (player.getLosses() < 0) {
            throw new InvalidOperation("Losses cannot go below 0");
        }
    }
}
