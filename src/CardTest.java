import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card queen;

    @BeforeEach
    void setUp() {
        queen = new Card(FaceValue.QUEEN, Suit.HEART);
    }

    @Test
    void testCard() {
        assertEquals(FaceValue.QUEEN, queen.value());
        assertEquals(Suit.HEART, queen.suit());
        System.out.println("Card info: " + queen);
    }
}