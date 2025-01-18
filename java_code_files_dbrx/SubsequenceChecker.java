public class SubsequenceChecker {
    // An example of pseudo code for a problem that could be classified as NPC if it's proven.
    // This problem asks whether there exists a sub-sequence equal to target in source string or not
    public Boolean existsSubseq(String source, String target) {
        // Guess solution (Non-deterministic approach): Return true when first character of guess is same
        // and rest can be found as subsequence too. Else false
        if (source.length() < target.length()) return false;
        if (source.charAt(0) == target.charAt(0)) {   // "guess" here means we have chosen the correct path,
                                                      // i.e., first characters match so let's check rest of them
            return existsSubseq(source.substring(1), target.substring(1)); // recursively checking for remaining
                                                                           // subsequence in sub-string excluding
                                                                           // already checked characters
        } else if (target.length() == 0) {     // all elements in guess are present, return true
            return true;
        } else {
            return false;         // this branch will not be taken if we have guessed correctly
        }
    }
}