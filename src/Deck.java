import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final Random random = new Random();

    private final List<Card> cards = new ArrayList<>();
    private int dealtIndex = 0;

    public Deck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit: Suit.values()) {
                cards.add(new Card(,suit));
            }
        }
    }
}
