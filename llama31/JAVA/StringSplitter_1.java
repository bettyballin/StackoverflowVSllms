import java.lang.String;

public class StringSplitter_1_1 {
    public String[] split(String str, char delimiter) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(delimiter, index)) != -1) {
            count++;
            index++;
        }
        count++; // to include the last substring

        String[] result = new String[count];
        index = 0;
        int i = 0;
        while ((index = str.indexOf(delimiter, index)) != -1) {
            result[i++] = str.substring(0, index);
            str = str.substring(index + 1);
        }
        result[i] = str; // the last substring

        return result;
    }

    public static void main(String[] args) {
        StringSplitter_1 splitter = new StringSplitter_1();
        String[] result = splitter.split("hello,world,java", ',');
        for (String s : result) {
            System.out.println(s);
        }
    }
}