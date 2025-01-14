import java.lang.String;
public class StringUtils_2 {
    public static String[] split(String str, char delimiter) {
        if (str == null || str.length() == 0) {
            return new String[0];
        }

        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                count++;
            }
        }

        String[] result = new String[count];
        int start = 0, j = 0;

        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == delimiter) {
                result[j++] = str.substring(start, i);
                start = i + 1;
            }
        }

        return result;
    }

	public static void main(String[] args) {
	}
}