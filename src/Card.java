public class Card {
    private final FaceValue value;
    private final Suit suit;

    public Card(FaceValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * get the card value
     * @return FaceValue
     */
    public FaceValue value() {
        return value;
    }

    /**
     * get the card suit
     * @return Suit
     */
    public Suit suit() {
        return suit;
    }

    /**
     * get the string of the card information
     * @return a string of suit and value information
     */
    @Override
    public String toString() {
        return suit.toString() + value.toString();
    }
}
