public class WordReverser {
    public static String reverseWordsInString(String s1) {
        char[] strArr = s1.toCharArray();

        int start = 0;
        int end = strArr.length - 1;
        char temp;

        // Step 1 - Reverse all characters in the entire string.
        while (start < end) {
            temp = strArr[start];
            strArr[start++] = strArr[end];
            strArr[end--] = temp;
        }

        // Step 2 - Reverse each word in the reversed string.
        int n = strArr.length;
        start = 0;
        while (start < n) {
            if (strArr[start] == ' ') {
                start++;
                continue;
            }
            end = start;
            while (end < n && strArr[end] != ' ') {
                end++;
            }
            // Reverse the word from 'start' to 'end - 1'
            int wordEnd = end - 1;
            int wordStart = start;
            while (wordStart < wordEnd) {
                temp = strArr[wordStart];
                strArr[wordStart++] = strArr[wordEnd];
                strArr[wordEnd--] = temp;
            }
            start = end;
        }

        return new String(strArr);
    }

    public static void main(String[] args) {
    }
}