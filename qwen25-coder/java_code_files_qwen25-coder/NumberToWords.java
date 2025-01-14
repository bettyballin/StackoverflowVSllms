import java.lang.String;
public class NumberToWords {

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
        "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String humanReadable(int number) {
        if (number == 0) return "zero";
        
        StringBuilder words = new StringBuilder();
        
        if ((number / 1_000_000_000) > 0) {
            words.append(convertHundreds(number / 1_000_000_000)).append(" billion ");
            number %= 1_000_000_000;
        }
        
        if ((number / 1_000_000) > 0) {
            words.append(convertHundreds(number / 1_000_000)).append(" million ");
            number %= 1_000_000;
        }
        
        if ((number / 1_000) > 0) {
            words.append(convertHundreds(number / 1_000)).append(" thousand ");
            number %= 1_000;
        }
        
        if (number > 0) {
            words.append(convertHundreds(number));
        }
        
        return words.toString().trim();
    }

    private static String convertHundreds(int num) {
        StringBuilder sb = new StringBuilder();
        
        int hundred = num / 100;
        num %= 100;
        
        if (hundred > 0) {
            sb.append(units[hundred]).append(" hundred ");
        }
        
        if (num > 19) {
            sb.append(tens[num / 10]);
            num %= 10;
        } else if (num > 0) {
            return sb.append(units[num]).toString().trim();
        }

        if (num != 0) {
            sb.append("-").append(units[num]);
        }
        
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(humanReadable(1)); // one
        System.out.println(humanReadable(53)); // fifty-three
        System.out.println(humanReadable(723603)); // seven hundred and twenty-three thousand six hundred and three
        System.out.println(humanReadable(1456376562)); // one billion four hundred and fifty-six million three hundred and seventy-six thousand five hundred and sixty-two
    }
}