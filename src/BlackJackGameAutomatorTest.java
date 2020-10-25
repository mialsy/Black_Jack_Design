import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackGameAutomatorTest {
    BlackJackGameAutomator bja;

    @BeforeEach
    void setUp() {
        System.out.println("Test blackJack game start with random number from 2-10");
        bja = new BlackJackGameAutomator(new Random().nextInt(9) + 2);
    }

    @Test
    void startGame() {
        bja.startGame();
    }
}