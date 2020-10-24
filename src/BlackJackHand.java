import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand{
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

    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card c: cards) {
            updareScores(c, scores);
        }
        return scores;
    }

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

    private int[] getScores(Card card) {
        if (card.value() == FaceValue.ACE) {
            return new int[]{1, 11};
        } else {
            return new int[] {Math.min(card.value().getNumericValue(), 10)};
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);

        return (card1.value() == FaceValue.ACE && isFaceCard(card2))
                || (card2.value() == FaceValue.ACE && isFaceCard(card1));

    }

    private static boolean isFaceCard(Card card) {
        return card.value() == FaceValue.JACK || card.value() == FaceValue.QUEEN || card.value() == FaceValue.KING;
    }
}
