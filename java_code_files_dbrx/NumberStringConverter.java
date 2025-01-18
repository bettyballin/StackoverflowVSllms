public class NumberStringConverter {
    protected Object stringToValue(String text) {
        if (text == null || text.length() < 1){
            return ""; // Or any other suitable value for an empty input or a default value like "0"
        } else{
            try {
                Double doubleNumber = Double.parseDouble(text);
                return doubleNumber;
            } catch (NumberFormatException e) {
                return text; // return the original string value when format exception is thrown while trying to parse it as a number
            }
        }
    }

    public static void main(String[] args) {
    }
}