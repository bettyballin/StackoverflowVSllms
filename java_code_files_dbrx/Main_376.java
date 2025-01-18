import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        diff_match_patch dmp = new diff_match_patch(); // Create DMP object

        String textOld = "The quick brown   fox jumped over the   lazy      dog.";
        String textNew = "The quick yellow foX jumped over the well-breed dog.";

        LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(textOld, textNew); // Compute the difference between old and new text
        String html = dmp.diff_prettyHtml(diffs); // Format it to a pretty HTML output
        System.out.println(html);
    }
}

// diff_match_patch class code starts here

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing the diff, match and patch methods.
 * Also contains the Diff, Patch and other data structures.
 */
class diff_match_patch {

  // Default settings.
  // Set these on your diff_match_patch instance to override the defaults.

  /**
   * Number of seconds to map a diff before giving up (0 for infinity).
   */
  public float Diff_Timeout = 0.0f;
  /**
   * Cost of an empty edit operation in terms of edit characters.
   */
  public short Diff_EditCost = 4;
  /**
   * At what point is no match declared (0.0 = perfection, 1.0 = very loose).
   */
  public float Match_Threshold = 0.5f;
  /**
   * How far to search for a match (0 = exact location, 1000+ = broad match).
   * A match this many characters away from the expected location will add
   * 1.0 to the score (0.0 is a perfect match).
   */
  public int Match_Distance = 1000;
  /**
   * When deleting a large block of text (over ~64 characters), how close do
   * the contents have to be to match the expected contents. (0.0 = perfection,
   * 1.0 = very loose).  Note that Match_Threshold controls how closely the
   * end points of a delete need to match.
   */
  public float Patch_DeleteThreshold = 0.5f;
  /**
   * Chunk size for context length.
   */
  public short Patch_Margin = 4;

  /**
   * The data structure representing a diff is a Linked list of Diff objects:
   * {Diff(Operation.DELETE, "Hello"), Diff(Operation.INSERT, "Goodbye"),
   *  Diff(Operation.EQUAL, " world.")}
   * which means: delete "Hello", add "Goodbye" and keep " world."
   */
  public enum Operation {
    DELETE, INSERT, EQUAL
  }

  /**
   * Class representing one diff operation.
   */
  public static class Diff {
    /**
     * One of: INSERT, DELETE or EQUAL.
     */
    public Operation operation;
    /**
     * The text associated with this diff operation.
     */
    public String text;

    /**
     * Constructor.  Initializes the diff with the provided values.
     * @param operation One of INSERT, DELETE or EQUAL.
     * @param text The text being applied.
     */
    public Diff(Operation operation, String text) {
      // Construct a diff with the specified operation and text.
      this.operation = operation;
      this.text = text;
    }

    /**
     * Display a human-readable version of this Diff.
     * @return text version.
     */
    public String toString() {
      String prettyText = this.text.replace('\n', '\u00b6');
      return "Diff(" + this.operation + ",\"" + prettyText + "\")";
    }

    /**
     * Is this Diff equivalent to another Diff?
     * @param obj Another Diff to compare against.
     * @return true or false.
     */
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof Diff)) {
        return false;
      }
      Diff other = (Diff) obj;
      if (operation != other.operation) {
        return false;
      }
      if (text == null) {
        if (other.text != null) {
          return false;
        }
      } else if (!text.equals(other.text)) {
        return false;
      }
      return true;
    }

    public int hashCode() {
      int result;
      result = (operation == null) ? 0 : operation.hashCode();
      result += (text == null) ? 0 : text.hashCode();
      return result;
    }
  }

  /**
   * Find the differences between two texts.
   * Run a faster slightly less optimal diff.
   * This method allows the 'Diff_Timeout' to be set to zero.
   * @param text1 Old string to be diffed.
   * @param text2 New string to be diffed.
   * @return Linked List of Diff objects.
   */
  public LinkedList<Diff> diff_main(String text1, String text2) {
    return diff_main(text1, text2, false);
  }

  /**
   * Find the differences between two texts.
   * @param text1 Old string to be diffed.
   * @param text2 New string to be diffed.
   * @param checklines Speedup flag.  If false, then don't run a
   *     line-level diff first to identify the changed areas.
   *     If true, then run a faster slightly less optimal diff.
   * @return Linked List of Diff objects.
   */
  public LinkedList<Diff> diff_main(String text1, String text2, boolean checklines) {
    // Set a deadline by which time the diff must be complete.
    long deadline;
    if (Diff_Timeout <= 0) {
      deadline = Long.MAX_VALUE;
    } else {
      deadline = System.currentTimeMillis() + (long) (Diff_Timeout * 1000);
    }
    return diff_main(text1, text2, checklines, deadline);
  }

  /**
   * Find the differences between two texts.  Simplifies the problem by
   * stripping any common prefix or suffix off the texts before diffing.
   * @param text1 Old string to be diffed.
   * @param text2 New string to be diffed.
   * @param checklines Speedup flag.  If false, then don't run a
   *     line-level diff first to identify the changed areas.
   *     If true, then run a faster slightly less optimal diff.
   * @param deadline Time when the diff should be complete by.  Used
   *     internally for recursive calls.  Users should set DiffTimeout instead.
   * @return Linked List of Diff objects.
   */
  private LinkedList<Diff> diff_main(String text1, String text2, boolean checklines,
                                     long deadline) {
    LinkedList<Diff> diffs = new LinkedList<Diff>();

    // Check for null inputs.
    if (text1 == null || text2 == null) {
      throw new IllegalArgumentException("Null inputs. (diff_main)");
    }

    // Check for equality (speedup).
    if (text1.equals(text2)) {
      if (text1.length() != 0) {
        diffs.add(new Diff(Operation.EQUAL, text1));
      }
      return diffs;
    }

    // Trim off common prefix (speedup).
    int commonlength = diff_commonPrefix(text1, text2);
    String commonprefix = text1.substring(0, commonlength);
    text1 = text1.substring(commonlength);
    text2 = text2.substring(commonlength);

    // Trim off common suffix (speedup).
    commonlength = diff_commonSuffix(text1, text2);
    String commonsuffix = text1.substring(text1.length() - commonlength);
    text1 = text1.substring(0, text1.length() - commonlength);
    text2 = text2.substring(0, text2.length() - commonlength);

    // Compute the diff on the middle block.
    diffs = diff_compute(text1, text2, checklines, deadline);

    // Restore the prefix and suffix.
    if (commonprefix.length() != 0) {
      diffs.addFirst(new Diff(Operation.EQUAL, commonprefix));
    }
    if (commonsuffix.length() != 0) {
      diffs.addLast(new Diff(Operation.EQUAL, commonsuffix));
    }

    diff_cleanupMerge(diffs);
    return diffs;
  }

  /**
   * Find the differences between two texts.  Assumes that the texts do not
   * have any common prefix or suffix.
   * @param text1 Old string to be diffed.
   * @param text2 New string to be diffed.
   * @param checklines Speedup flag.  If false, then don't run a
   *     line-level diff first to identify the changed areas.
   *     If true, then run a faster slightly less optimal diff.
   * @param deadline Time when the diff should be complete by.
   * @return Linked List of Diff objects.
   */
  private LinkedList<Diff> diff_compute(String text1, String text2, boolean checklines,
                                        long deadline) {
    LinkedList<Diff> diffs = new LinkedList<Diff>();

    if (text1.length() == 0) {
      // Just add some text (speedup).
      diffs.add(new Diff(Operation.INSERT, text2));
      return diffs;
    }

    if (text2.length() == 0) {
      // Just delete some text (speedup).
      diffs.add(new Diff(Operation.DELETE, text1));
      return diffs;
    }

    String longtext = text1.length() > text2.length() ? text1 : text2;
    String shorttext = text1.length() > text2.length() ? text2 : text1;
    int i = longtext.indexOf(shorttext);
    if (i != -1) {
      // Shorter text is inside the longer text (speedup).
      Operation op = (text1.length() > text2.length()) ? Operation.DELETE : Operation.INSERT;
      diffs.add(new Diff(op, longtext.substring(0, i)));
      diffs.add(new Diff(Operation.EQUAL, shorttext));
      diffs.add(new Diff(op, longtext.substring(i + shorttext.length())));
      return diffs;
    }

    if (shorttext.length() == 1) {
      // Single character string.
      // After the previous speedup, the character can't be an equality.
      diffs.add(new Diff(Operation.DELETE, text1));
      diffs.add(new Diff(Operation.INSERT, text2));
      return diffs;
    }

    // Check to see if the problem can be split in two.
    String[] hm = diff_halfMatch(text1, text2);
    if (hm != null) {
      // A half-match was found, sort out the return data.
      String text1_a = hm[0];
      String text1_b = hm[1];
      String text2_a = hm[2];
      String text2_b = hm[3];
      String mid_common = hm[4];

      // Send both pairs off for separate processing.
      LinkedList<Diff> diffs_a = diff_main(text1_a, text2_a, checklines, deadline);
      LinkedList<Diff> diffs_b = diff_main(text1_b, text2_b, checklines, deadline);

      // Merge the results.
      diffs = diffs_a;
      diffs.add(new Diff(Operation.EQUAL, mid_common));
      diffs.addAll(diffs_b);
      return diffs;
    }

    if (checklines && text1.length() > 100 && text2.length() > 100) {
      return diff_lineMode(text1, text2, deadline);
    }

    return diff_bisect(text1, text2, deadline);
  }

  // Remaining methods (diff_commonPrefix, diff_commonSuffix, diff_halfMatch,
  // diff_lineMode, diff_bisect, diff_cleanupMerge, etc.) would go here.
  // Due to space constraints, they are not included in this snippet.
  // You can find the full implementation in the original diff_match_patch library.

  /**
   * Reduce the number of edits by eliminating operationally trivial equalities.
   * @param diffs LinkedList of Diff objects.
   */
  public void diff_cleanupMerge(LinkedList<Diff> diffs) {
    // Implementation goes here.
    // For brevity, the full method is not included.
  }

  /**
   * Pretty print.
   * @param diffs LinkedList of Diff objects.
   * @return HTML representation.
   */
  public String diff_prettyHtml(LinkedList<Diff> diffs) {
    StringBuilder html = new StringBuilder();
    for (Diff aDiff : diffs) {
      String text = aDiff.text.replace("&", "&amp;").replace("<", "&lt;")
          .replace(">", "&gt;").replace("\n", "&para;<br>");
      switch (aDiff.operation) {
        case INSERT:
          html.append("<ins style=\"background:#e6ffe6;\">").append(text)
              .append("</ins>");
          break;
        case DELETE:
          html.append("<del style=\"background:#ffe6e6;\">").append(text)
              .append("</del>");
          break;
        case EQUAL:
          html.append("<span>").append(text).append("</span>");
          break;
      }
    }
    return html.toString();
  }

  // Helper methods for the diff algorithms.
  // The full implementations would be included here.
}