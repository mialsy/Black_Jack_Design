import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
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

    /**
     * Initial Deal - deal 2 cards to each of the hand
     * @return {@code true} if the deal succeed, {@code false} if not
     */
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

    /**
     * Get the index of the hands that are the blackjacks
     * @return a list of hand index that is blackjack
     */
    protected List<Integer> getBlackJacks() {
        List<Integer> blackJacks = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                blackJacks.add(i);
            }
        }
        return blackJacks;
    }

    /**
     * Play hand, deal one card to the given hand
     * @param hand the hand to deal card to
     * @return {@code true} if this action succeed, {@code false} if not
     */
    protected boolean playHand(BlackJackHand hand) {
        while (hand.score() < HIT_UNIIL_SCORE) {
            Card card = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCards(new Card[] {card});
        }
        return true;
    }

    /**
     * Play all hand in the hands list
     * @return {@code true} if all hand play succeed, {@code false}  if one or more hand plays did not succeed
     */
    protected boolean playAllHands() {
        for (BlackJackHand hand: hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the index of the hands that are winners
     * @return a list of hand index that is winners
     */
    protected List<Integer> getWinners() {
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand cur = hands[i];
            if (!cur.busted()) {
                int score = cur.score();
                if (score > winningScore) {
                    winningScore = score;
                    winners.clear();
                    winners.add(i);
                } else if (score == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    /**
     * display the status of the hands including cards, and score
     */
    protected void display() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
            hands[i].print();
            System.out.println();
        }
    }

    public void startGame() {
        initDeck();

        boolean success = initDeal();
        if(!success) {
            System.out.println("Out of cards");
            return;
        }

        System.out.println("Display initial states: ");
        display();

        List<Integer> blackjacks = getBlackJacks();
        if (!blackjacks.isEmpty()) {
            System.out.println("Blackjacks: ");
            for (int i : blackjacks) {
                System.out.print("hand " + i + " ");
            }
            System.out.println();
            return;
        }

        success = playAllHands();

        if(!success) {
            System.out.println("Out of cards");
            return;
        }

        System.out.println("\n Completed game state: ");
        display();
        List<Integer> winners = getWinners();
        if (!winners.isEmpty()) {
            System.out.println("Winners: ");
            for (int i : winners) {
                System.out.print("hand " + i + " ");
            }
            System.out.println();
        } else {
            System.out.println("Draw, all players have busted. ");
        }
    }
}
