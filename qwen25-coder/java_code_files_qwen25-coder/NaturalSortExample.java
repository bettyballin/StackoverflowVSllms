import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;

public class NaturalSortExample {
    public static void main(String[] args) {
        String[] versions = {"1.2.9.1", "1.2.10.5"};

        Arrays.sort(versions, StringUtils::compareNatural);

        System.out.println(Arrays.toString(versions));
    }
}