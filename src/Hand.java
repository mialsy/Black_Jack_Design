import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Hand {
    protected final List<Card> cards = new ArrayList<>();

    /**
     * Calculate score
     * @return an int value of the score
     */
    public abstract int score();

    /**
     * Add all cards in the card list to hand
     * @param cardArr the array of cards to add
     */
    public void addCards(Card[] cardArr) {
        Collections.addAll(cards, cardArr);
    }

    /**
     * Check how many card are currently on hand
     * @return the int value of the card count
     */
    public int size() {
        return cards.size();
    }

    /**
     * Print the cards on hand
     */
    public void print() {
        System.out.print(cards);
    }
}
