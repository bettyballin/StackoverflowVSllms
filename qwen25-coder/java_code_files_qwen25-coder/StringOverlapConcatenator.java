public class StringOverlapConcatenator {
    public static String concat(String s1, String s2) {
        if (s1 == null)
            return s2;
        if (s2 == null)
            return s1;

        int maxOverlap = 0;
        long hashS1Suffix = 0;
        long hashS2Prefix = 0;
        long base = 256; // Use a prime number for better distribution
        long modulus = 10_000_009L; // A large prime modulus to avoid collisions

        for (int len = Math.min(s1.length(), s2.length()); len > 0; len--) {
            if (len == Math.min(s1.length(), s2.length())) {
                // Initial hash calculation for the last 'len' characters of s1 and first 'len' characters of s2
                for (int i = 0; i < len; i++) {
                    hashS1Suffix = (hashS1Suffix * base + s1.charAt(s1.length() - 1 - i)) % modulus;
                    hashS2Prefix = (base * hashS2Prefix + s2.charAt(i)) % modulus;
                }
            } else {
                // Update the hashes by removing the last character of previous suffix and adding the first character of new suffix
                int oldSuffixChar = s1.charAt(s1.length() - len);
                int newSuffixChar = s1.charAt(s1.length() - len);

                hashS1Suffix = ((hashS1Suffix - (oldSuffixChar * (long) Math.pow(base, len - 1)) % modulus + modulus) * base + newSuffixChar) % modulus;

                // Update the hashes by removing the first character of previous prefix and adding the last character of new prefix
                int oldPrefixChar = s2.charAt(len - 1);
                int newPrefixChar = 0;
                if (len < s2.length()) {
                    newPrefixChar = s2.charAt(len);
                }
                hashS2Prefix = ((hashS2Prefix - (oldPrefixChar * (long) Math.pow(base, len - 1)) % modulus + modulus) * base + newPrefixChar) % modulus;

                // Adjust for negative hashes
                if (hashS1Suffix < 0) hashS1Suffix += modulus;
                if (hashS2Prefix < 0) hashS2Prefix += modulus;
            }

            if (hashS1Suffix == hashS2Prefix && s1.substring(s1.length() - len).equals(s2.substring(0, len))) {
                maxOverlap = len;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2.substring(maxOverlap));
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}