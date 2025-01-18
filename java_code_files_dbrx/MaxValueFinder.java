import java.lang.String;
import java.lang.Integer;
import java.util.List;
import java.util.ArrayList;

public class MaxValueFinder {

    int maxValue = Integer.MIN_VALUE; // change type according to target column datatype.
    List<YourModel> parsedJsonArray = new ArrayList<>();

    {
        // Sample data added to parsedJsonArray for demonstration
        parsedJsonArray.add(new YourModel(5));
        parsedJsonArray.add(new YourModel(10));
        parsedJsonArray.add(new YourModel(3));

        for (YourModel item : parsedJsonArray) {
            if(item.target_column > maxValue){
                maxValue = item.target_column;
            }
        }
    }

    public static void main(String[] args) {
        MaxValueFinder finder = new MaxValueFinder();
        System.out.println("Max value is: " + finder.maxValue);
    }
}

class YourModel {
    public int target_column;

    public YourModel(int target_column) {
        this.target_column = target_column;
    }
}