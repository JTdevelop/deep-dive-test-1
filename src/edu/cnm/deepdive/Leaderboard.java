package edu.cnm.deepdive;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * The static methods of this class compute rankings of an input array of scores against a
 * leaderboard of scores.
 *
 * We want to determine Alice's rank as she progresses up the leaderboard. For example, the four
 * players on the leaderboard have high scores of 100, 90, 90, and 80. Using dense ranking those
 * players will have ranks 1, 2, 2, and 3 respectively. If Alice's scores are 70, 80 and 105, her
 * rankings after each game using dense ranking are 4, 3 and 1.
 *
 * You are given an array, <code>leaderboard</code>, of monotonically decreasing leaderboard scores,
 * and another array, <code>scores</code>, of Alice's scores for the game. You must print j
 * integers. The jth integer should indicate the current rank of Alice after her jth game.
 *
 * <h3>Sample Input</h3>
 * <pre><code>
 * 7
 * 100 100 50 40 40 20 10
 * 4
 * 5 25 50 120
 * </code></pre>
 *
 * <h3>Sample Output (Dense Ranking)</h3>
 * <pre><code>
 * 6
 * 4
 * 2
 * 1
 * </code></pre>
 *
 * <h3>Sample Output (Competition Ranking)</h3>
 * <pre><code>
 * 8
 * 6
 * 3
 * 1
 * </code></pre>
 */
public class Leaderboard {

  private Leaderboard() {
  }

  /**
   * Computes and returns an array of rankings, corresponding to the values in the
   * <code>scores</code> array. These should use the common "competition" ranking scheme &ndash;
   * for
   * example, if 2 players are tied for 1<sup>st</sup> place, the player with the next lower score
   * is assumed to in 3<sup>rd</sup> place. Another way of thinking about this scheme is that if a
   * player is in <i>n</i><sup>th</sup> place, according to this scheme, then there are exactly
   * (<i>n</i> - 1) players with a higher score.
   *
   * @param leaderboard scores on the leaderboard, in non-ascending order.
   * @param scores scores to be ranked against leaderboard scores.
   * @return resulting ranks.
   */
  public static int[] getCompetitionRanking(int[] leaderboard, int[] scores) {
    int[] ranks = new int[scores.length];
    // Iterate from lowest to highest values of leaderboard and scores.
    int leaderIndex = leaderboard.length;
    for (int scoreIndex = 0; scoreIndex < scores.length; scoreIndex++) {
      // Move backwards in leaderboard, until we reach teh start or find a value higher than score.
      while (leaderIndex > 0 && leaderboard[leaderIndex - 1] <= scores[scoreIndex]) {
        leaderIndex--;
      }
      ranks[scoreIndex] = leaderIndex + 1;
    }
    return ranks;
  }

  /**
   * Computes and returns an array of rankings, corresponding to the values in the
   * <code>scores</code> array. These should use the dense ranking scheme &ndash; for example, if 2
   * players are tied for 1<sup>st</sup> place, the player with the next lower score is assumed to
   * be in 2<sup>rd</sup> place. Another way of thinking about this scheme is that if a player is
   * in
   * <i>n</i><sup>th</sup> place, according to this scheme, then there are
   * exactly (<i>n</i> - 1) higher score values, some of which may have been scored by more than one
   * player.
   *
   * @param leaderboard scores on the leaderboard, in non-ascending order.
   * @param scores scores to be ranked against leaderboard scores.
   * @return resulting ranks.
   */
  
  public static int[] getDenseRanking(int[] leaderboard, int[] scores) {
    /*
  A simple (but inefficient) method of removing tie scores is to use the
  Stream.distinct() method: int[] distinctLeaderboard = IntStream.of(leaderboard).distinct().toArray();
  A better (more performant) method, since we know leaderboard is already in sorted order, is to use an
  INTPredicate to filter out adjacent duplicates:
   */
    class NoRepeatFilter implements IntPredicate {

      private int prev = Integer.MIN_VALUE;

      @Override
      public boolean test(int value) {
        if (value != prev) {
          prev = value;
          return true;
        } else {
          return false;
        }
      }
    }
    int[] distinctLeaderboard = IntStream.of(leaderboard).filter(new NoRepeatFilter()).toArray();
    return getCompetitionRanking(distinctLeaderboard, scores);
  }
}
