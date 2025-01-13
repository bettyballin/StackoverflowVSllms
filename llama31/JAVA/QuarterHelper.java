import java.lang.String;
public class QuarterHelper {
    public String getQuarter(int i){
        String quarter;
        switch(i){
            case 1: quarter = "Winter";
            break;

            case 2: quarter = "Spring";
            break;

            case 3: quarter = "Summer I";
            break;

            case 4: quarter = "Summer II";
            break;

            case 5: quarter = "Fall";
            break;

            default: quarter = "ERROR";
        }

        return quarter;
    }

	public static void main(String[] args) {
	}
}