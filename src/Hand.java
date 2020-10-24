import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    protected final List<Card> cards = new ArrayList<>();

    public abstract int score();
}
