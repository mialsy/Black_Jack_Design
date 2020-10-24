import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple version of black jack game
 * All player plays like a dealer,
 * i.e. if their score is less than HIT_UNTIL_SCORE, they keep getting new cards.
 */
public class BlackJackGameAutomator {
    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNIIL_SCORE = 16;

    public BlackJackGameAutomator(int playerCount) {
        hands = new BlackJackHand[playerCount];
        Arrays.fill(hands, new BlackJackHand());
    }

    /**
     * Create a new deck and shuffle the cards
     */
    protected void initDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    protected boolean initDeal() {
        for (BlackJackHand hand: hands) {
            Card[] cards = deck.dealHand(2);
            if (cards == null) {
                return false;
            } else {
                hand.addCards(cards);
            }
        }
        return true;
    }

    //TODO
    protected List<Integer> getBlackJacks() {

    }

    //TODO
    protected boolean playHand(BlackJackHand hand) {

    }

    //TODO
    protected void playAllHands() {

    }

    //TODO
    protected List<Integer> getWinners() {
        List<Integer> winnders = new ArrayList<>();
    }

    protected void displayHandsAndScores() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
            hands[i].print();
            System.out.println();
        }
    }

    public void startGame() {
        initDeck();
    }
}
