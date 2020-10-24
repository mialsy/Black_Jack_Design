//import java.util.ArrayList;
//import java.util.List;
//
//public class BlackJackHand extends Hand{
//    @Override
//    public int score() {
//        List<Integer> scores = possibleScores();
//
//    }
//
//    private List<Integer> possibleScores() {
//        List<Integer> scores = new ArrayList<>();
//        for (Card c: cards) {
//            updareScores(c, scores);
//        }
//        return scores;
//    }
//
//    private void updareScores(Card card, List<Integer> scores) {
//        final int[] toAdd = getScores(card);
//
//    }
//
//    private int[] getScores(Card card) {
//        if (card.value() != FaceValue.ACE) {
//            return new int[] {Math.min(card.value().getNumericValue(), 10)};
//        } else {
//            return new int[]{1, 11};
//        }
//    }
//}
