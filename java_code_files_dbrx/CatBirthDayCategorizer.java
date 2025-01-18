import java.util.ArrayList;
import java.util.List;

class Cat {
    // Empty class definition
}

public class CatBirthDayCategorizer {

    int firstBirthdayCatIndex = 0;
    int lastBirthdayCatIndexPlusOne = 10;
    List<Cat> catsList = new ArrayList<>();

    List<Cat> allTheCatsWithSameBDay;

    {
        allTheCatsWithSameBDay = new ArrayList<>(lastBirthdayCatIndexPlusOne - firstBirthdayCatIndex); // sublist constructor takes begin and end indexes, not lengths!
        allTheCatsWithSameBDay.addAll(catsList.subList(firstBirthdayCatIndex, lastBirthdayCatIndexPlusOne));
    }

    public static void main(String[] args) {
    }
}