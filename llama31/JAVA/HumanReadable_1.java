public class HumanReadable_1 {
    private static final String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] thousands = {"", "thousand", "million", "billion"};

    public static String humanReadable(long number) {
        if (number == 0) return "zero";

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                result.insert(0, helper(number % 1000) + " " + thousands[i] + (number % 1000 == 1 && i > 0 ? "" : "") + (result.length() > 0 ? ", " : ""));
            }
            number /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private static String helper(long number) {
        if (number == 0) return "";
        if (number < 10) return ones[(int) number];
        if (number < 20) return teens[(int) number - 10];
        if (number < 100) return tens[(int) number / 10] + (number % 10 != 0 ? "-" + ones[(int) number % 10] : "");
        return ones[(int) number / 100] + " hundred" + (number % 100 != 0 ? " and " + helper(number % 100) : "");
    }

    public static void main(String[] args) {
        System.out.println(HumanReadable.humanReadable(1)); // "one"
        System.out.println(HumanReadable.humanReadable(53)); // "fifty-three"
        System.out.println(HumanReadable.humanReadable(723603)); // "seven hundred and twenty-three thousand, six hundred and three"
        System.out.println(HumanReadable.humanReadable(1456376562)); // "one billion, four hundred and fifty-six million, three hundred and seventy-six thousand, five hundred and sixty-two"
    }
}