package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
  Implements a Junit Test

 */
class StaircaseTest {

  static final int[] HEIGHTS = {2, 5};
  static final String[][] LINEAR_STAIRS_EXPECTED = {
      new String[]{
          " *",
          "**"
      },
      new String[]{
          "    *",
          "   **",
          "  ***",
          " ****",
          "*****"
      }
  };

  static private Staircase staircase = new Staircase();

  @Test
  void buildLinearStaircase() {
    for (i = 0; i < HEIGHTS.length; i++) {
      assertArrayEquals(LINEAR_STAIRS_EXPECTED[i], staircase.buildLinearStaircase(HEIGHTS[i]));
    }
  }
}