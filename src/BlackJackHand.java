import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand{
    /**
     * Calculate the score based on hand cards
     * @return an int value of best score the player can get
     */
    @Override
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (int score: scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver: maxUnder;
    }

    /**
     * Calculate all possible score based on the current hand cards
     * @return a list of Integer which is all possible scores
     */
    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card c: cards) {
            updareScores(c, scores);
        }
        return scores;
    }

    /**
     * Update scores based on given card
     * @param card the input card
     * @param scores the scores list to update on
     */
    private void updareScores(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card);
        if (scores.isEmpty()) {
           for (int score : toAdd) {
               scores.add(score);
           }
        } else {
            final int length = scores.size();
            for (int i = 0; i < length; i++) {
                int oldScore = scores.get(i);
                scores.set(i, oldScore + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
            }
        }

    }

    /**
     * Get the possible scores of the given card
     * @param card the card to calculate the score
     * @return an int array of possible scores
     */
    private int[] getScores(Card card) {
        if (card.value() == FaceValue.ACE) {
            return new int[]{1, 11};
        } else {
            return new int[] {Math.min(card.value().getNumericValue(), 10)};
        }
    }

    /**
     * Check if the hand is busted
     * @return {@code true} if score is over 21, {@code false} if otherwise
     */
    public boolean busted() {
        return score() > 21;
    }

    /**
     * Check if the hand is Black Jack
     * @return {@code true} if the hand is black jack (with card A and face card), {@code false} if otherwise
     */
    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        return (card1.value() == FaceValue.ACE && isFaceCard(card2))
                || (card2.value() == FaceValue.ACE && isFaceCard(card1));

    }

    /**
     * Check if given card is face card
     * @param card the input card to check
     * @return {@code true} if the card is face card, {@code false} if the card is not
     */
    private static boolean isFaceCard(Card card) {
        return card.value() == FaceValue.JACK || card.value() == FaceValue.QUEEN || card.value() == FaceValue.KING;
    }
}
