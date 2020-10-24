public class Card {
    private final FaceValue value;
    private final Suit suit;

    public Card(FaceValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public FaceValue value() {
        return value;
    }

    public Suit suit() {
        return suit;
    }
}
