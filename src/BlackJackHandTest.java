import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BlackJackHandTest {
    private static BlackJackHand hand1;
    private static BlackJackHand hand2;
    private static Card[] cards1 = new Card[]{new Card(FaceValue.ACE, Suit.HEART), new Card(FaceValue.QUEEN, Suit.HEART)};
    private static Card[] cards2 = new Card[]{new Card(FaceValue.KING, Suit.HEART), new Card(FaceValue.QUEEN, Suit.HEART), new Card(FaceValue.C2, Suit.CLUB)};

    @BeforeAll
    static void setUp() {
        System.out.println("init test");
        hand1 = new BlackJackHand();
        hand2 = new BlackJackHand();
        assertNotNull(hand1);
        assertNotNull(hand2);
    }

    @Test
    @Order(1)
    void addCards() {
        System.out.println("test addCards");
        hand1.addCards(cards1);
        hand2.addCards(cards2);
    }

    @Test
    @Order(3)
    void size() {
        System.out.println("test size");
        assertEquals(hand1.size(), 2);
        assertEquals(hand2.size(), 3);
    }

    @Test
    @Order(2)
    void print() {
        System.out.println("test print");
        hand1.print();
        hand2.print();
    }

    @Test
    @Order(4)
    void score() {
        System.out.println("test score");
        assertEquals(hand1.score(), 11 + 10);
        assertEquals(hand2.score(), 10 + 10 + 2);
    }

    @Test
    @Order(5)
    void busted() {
        System.out.println("Test busted");
        assertFalse(hand1.busted());
        assertTrue(hand2.busted());
    }

    @Test
    @Order(6)
    void isBlackJack() {
        System.out.println("Test isBlackJack");
        assertTrue(hand1.isBlackJack());
        assertFalse(hand2.isBlackJack());
    }

}