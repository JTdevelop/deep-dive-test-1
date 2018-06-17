package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

  static final int[][] LEADERBOARD = {
      {100, 100, 50, 40, 40, 20, 10},
      {100, 90, 80, 80, 80, 20},
      {100, 90, 90, 80, 80, 80, 70, 60, 30}
  };

  static final int[][] SCORES = {
      {5, 25, 50, 120},
      {10, 50, 80, 90},
      {10, 10, 20, 40, 40, 75, 95, 100, 110}
  };

  static final int[][] COMPETITION_RANKING = {
      {8, 6, 3, 1},
      {7, 6, 3, 2},
      {10, 10, 10, 9, 9, 7, 2, 1, 1}
  };

  static final int[][] DENSE_RANKING = {
      {6, 4, 2, 1},
      {5, 4, 3, 2},
      {7, 7, 7, 6, 6, 4, 2, 1, 1}
  };



  @org.junit.jupiter.api.Test
  void getCompetitionRanking() {


  }

  @org.junit.jupiter.api.Test
  void getDenseRanking() {
  }
}