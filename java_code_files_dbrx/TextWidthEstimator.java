import java.util.*;

public class TextWidthEstimator {
    private Map<Character, Double> charScores = new HashMap<>();

    public TextWidthEstimator() {
        // Fill character scores here based on your data or typeface measurement table:
        this.charScores.put('i', 0.25);
        this.charScores.put('l', 0.4 );
        this.charScores.put('m', 0.78);
        this.charScores.put('w', 0.63);
    }

    public double getWidthEstimate(String s) {
        double score = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (this.charScores.containsKey(s.charAt(i))){
                score += this.charScores.get(s.charAt(i));
            } else { // use some default value for characters not in our map
                score += 0.5;
            }
        }
        return score / s.length(); // return the average width estimate
    }

    public static void main(String[] args) {
    }
}