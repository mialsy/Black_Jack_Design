import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final Random random = new Random();

    private final List<Card> cards = new ArrayList<>();
    private int dealtIndex = 0;

    /**
     * Create a standard deck with 4 suits and 13 cards for each suit
     * cards include 2-10, A, J, Q, K
     */
    public Deck() {
        for (FaceValue faceValue: FaceValue.values()) {
            for (Suit suit: Suit.values()) {
                cards.add(new Card(faceValue,suit));
            }
        }
    }

    /**
     * shuffle the cards on the deck
     */
    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    /**
     * Get the remain card number
     * @return an int value of the remain card number
     */
    private int remainCards() {
        return cards.size() - dealtIndex;
    }

    /**
     * Deal given number of card to the hand
     * @param num the number of card
     * @return a Card array of given number, return null if there are not enough cards
     */
    public Card[] dealHand(int num) {
        if (remainCards() < num) {
            return null;
        }
        Card[] cards = new Card[num];
        for (int i = 0; i < num; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    /**
     * deal one card
     * @return the card to deal
     */
    public Card dealCard() {
        return remainCards() == 0 ? null : cards.get(dealtIndex++);
    }

    /**
     * reset the deck and shuffle
     */
    public void reset() {
        dealtIndex = 0;
        shuffle();
    }
}
