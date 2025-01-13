import java.lang.String;
public class HumanReadable {
    private static final String[] ones = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String humanReadable(int num) {
        if (num == 0) return "zero";

        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("minus ");
            num = -num;
        }

        int billion = num / 1_000_000_000;
        int million = (num % 1_000_000_000) / 1_000_000;
        int thousand = (num % 1_000_000) / 1_000;
        int rest = num % 1_000;

        if (billion > 0) {
            sb.append(humanReadable(billion)).append(" billion");
            if (million > 0 || thousand > 0 || rest > 0) sb.append(", ");
        }
        if (million > 0) {
            sb.append(humanReadable(million)).append(" million");
            if (thousand > 0 || rest > 0) sb.append(", ");
        }
        if (thousand > 0) {
            sb.append(humanReadable(thousand)).append(" thousand");
            if (rest > 0) sb.append(", ");
        }
        if (rest > 0) {
            sb.append(humanReadableRest(rest));
        }

        return sb.toString();
    }

    private static String humanReadableRest(int num) {
        if (num < 10) return ones[num];
        if (num < 20) return teens[num - 10];
        if (num < 100) return tens[num / 10] + (num % 10 > 0 ? "-" + ones[num % 10] : "");
        if (num < 1000) {
            if (num % 100 == 0) return ones[num / 100] + " hundred";
            return ones[num / 100] + " hundred and " + humanReadableRest(num % 100);
        }
        return "";
    }

	public static void main(String[] args) {
	}
}