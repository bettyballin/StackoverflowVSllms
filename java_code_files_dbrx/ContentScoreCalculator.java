import java.lang.String;
import java.util.Calendar;

public class ContentScoreCalculator {
    double calculateScore(int upVotes, int downVotes, long datePublished) {
        final double gravity = 1.8; // "gravity" is the value that pulls good content higher and older content lower over time
        if (downVotes > 0) {              // remove negatively scored items:
            return -1;                     // we want only popular content!
        } else if (datePublished == 0) {      // ignore very recent articles:
            return upVotes;            // don't allow sort by date in this version of the algorithm.
        }

       /* formula source: http://blog.stackoverflow.com/2010/09/good-subjective-bad-subjective/
        * score = (p - 1) / (n + m)^g where
          p = # of 'pro' votes,
          n = # of against votes,
          m = min "vote threshold" required to be considered a candidate, and
         g = Gravity constant ("score decays over time": currently set at 1.8)
        * The minimum score is -2 if the number of positive vote is less than
        */

        int votesAgainstThreshold = 3; // if there are more "againsts" than this, don't show it in the UI!
        long timeSincePublished = Calendar.getInstance().getTimeInMillis() - datePublished;

        double s = Math.max(0, (upVotes - 1) / Math.pow((downVotes + votesAgainstThreshold), gravity));
        // don't want to show if it has been down voted over the threshold, or else its score < -2
        return (s > 2 || (s == 0 && upVotes > 0)) ? s : -1;
    }

    public static void main(String[] args) {
    }
}