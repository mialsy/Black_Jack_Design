import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeckTest {
    private static Deck deck;

    @BeforeAll
    static void setUp() {
        deck = new Deck();
        System.out.println("Init test, deck before shuffle: ");
        System.out.println(deck);
    }

    @Test
    @Order(1)
    void shuffle() {
        deck.shuffle();
        System.out.println("Deck after shuffle");
        System.out.println(deck);
    }

    @Test
    @Order(2)
    void dealHand() {
        System.out.println("Deal 3 cards: ");
        Card[] cards = deck.dealHand(3);
        assertEquals(3, cards.length);
        System.out.println(Arrays.toString(cards));
    }

    @Test
    @Order(3)
    void dealCard() {
        System.out.println("Deal one card: ");
        Card c = deck.dealCard();
        System.out.println(c);
    }

    @Test
    @Order(4)
    void reset() {
        deck.reset();
        System.out.println("Reset deck, sequence of cards should be different: ");
        System.out.println(deck);
    }
}