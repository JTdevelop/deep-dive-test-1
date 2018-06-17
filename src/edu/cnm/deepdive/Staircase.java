package edu.cnm.deepdive;

/**
 * The static methods in this class build string array "staircases".
 * <p>
 *   Consider a text staircase of height 6:
 * </p>
 * <pre><code>      *
 *     **
 *    ***
 *   ****
 *  *****
 * ******</code></pre>
 * <p>
 *   Note that each line consists of spaces and the asterisk character. Further,
 *   each line has the exact same number of characters, so that (when a
 *   monospace font is used), the right edges line up. Finally, note that though
 *   the last line appears to have a leading space, the staircases produced by
 *   your code should end with a string with no leading spaces.
 * </p>
 * <p>
 *   Your task will be to write code to construct such staircases, and return
 *   them as an array of strings. The 1<sup>st</sup>element will have a single
 *   asterisk, with leading spaces as necessary; the last element will have
 *   asterisks only; all the previous strings in the array should be left-padded
 *   as necessary so that all of the strings are of the same length &ndash; i.e.
 *   when printed out, one string per line, the right edges will be aligned in
 *   the printout.
 * </p>
 * <p>
 *   In the basic problem, the staircase is linear &ndash; that is, when
 *   counting from the top of the staircase down, each successive string has 1
 *   more asterisk than the previous.
 * </p>
 * <p>
 *   There is an extra credit problem as well. In this problem, the staircase
 *   doesn't ascend/descend in a linear fashion, but as a Fibonacci sequence.
 *   That is, the top 2 steps have one asterisk each, but each successively
 *   lower step has as many asterisks as the sum of the previous 2. For example,
 *   a Fibonacci staircase of height 6 would appear as the following:
 * </p>
 * <pre><code>         *
 *         *
 *        **
 *       ***
 *     *****
 * *********</code></pre>
 * <h3>Assumptions</h3>
 * <ol>
 *   <li>The value of <code>height</code> parameter will always be in the
 *   range 2 to 10, inclusive.</li>
 *   <li>Whether your code prints anything out is up to you. What it
 *   <strong>must</strong> do, however is return a {@link String String[]}
 *   &ndash; i.e. an array of strings.</li>
 * </ol>
 * <h3>Basic test cases</h3>
 * <p>
 *   Please note that the values below are guaranteed to be included in the test
 *   cases; others may be included at our discretion. However, if your code
 *   works correctly with the cases below, and assuming it doesn't simply have
 *   hard-coded conditions looking for these specific inpupt values, it should
 *   have no problem with additional test values. In other words, your code
 *   should include the necessary computations to handle general cases, and not
 *   just those shown here.
 * </p>
 * <table summary="Test inputs and expected outputs" class="striped">
 *   <thead>
 *     <tr>
 *       <th><code>height</code></th>
 *       <th><code>buildLinearStaircase(height)</code></th>
 *       <th><code>buildFibonacciStaircase(height)</code></th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td><code>2</code></td>
 *       <td><pre><code>  *
 * **</code></pre></td>
 *       <td><pre><code> *
 * *</code></pre></td>
 *     </tr>
 *     <tr>
 *       <td><code>5</code></td>
 *       <td>
 * <pre><code>     *
 *    **
 *   ***
 *  ****
 * *****</code></pre>
 *       </td>
 *       <td>
 * <pre><code>     *
 *     *
 *    **
 *   ***
 * *****</code></pre>
 *       </td>
 *     </tr>
 *   </tbody>
 * </table>
 */
public class Staircase {

  /**
   * Constructs and returns an array of strings, where the first element is the
   * top step of the staircase, containing a single asterisk (*), right-aligned
   * (that is, padded on the left with spaces, as necessary), and each
   * successive element is a string containing one more asterisk than the
   * previous. The final string in the array should have <code>height</code>
   * asterisk characters, without any leading spaces.
   *
   * @param height  staircase height (number of steps).
   * @return        array of length <code>height</code>.
   */
  public static String[] buildLinearStaircase(int height) {
      String [] length = new String[height];
      String steps = "*";

      for(int i=0; i < height; i++); {
        length[i]  = String.format("%1$" +height+ "s", steps);
        steps += "*";
    }
    return length;
   }

  /**
   * Constructs and returns an array of strings, where the first element is the
   * top step of the staircase, containing a single asterisk (*), right-aligned
   * (that is, padded on the left with spaces, as necessary); the second element
   * also has a single asterisk, right-aligned (left-padded); each
   * successive element is a string containing a number of asterisks equal to the
   * the sum of the number of asterisks in the previous 2 elements. For example,
   * the 3<sup>rd</sup> element will have 1 + 1 = 2 asterisks; the 4<sup>th</sup>
   * will have 2 + 1 = 3 asterisks; etc. The last element of the array should
   * contain nothing but asterisks.
   *
   * @param height  staircase height (number of steps).
   * @return        array of length <code>height</code>.
   */
     public static String[] buildFibonacciStaircase(int height) {
       if (height <= 1) {
         return 1;
       }
       return recursive(height - 1) + recursive(height - 2);
     }

  public static long iterative(int height) {
    long prev2 = 1;
    long prev1 = 1;
    if (height == 0) {
      return prev2;
    }
    if (height == 1) {
      return prev1;
    }
    for (int i = 2; i <= height; i++) {
      long current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return prev1;
  }

}
