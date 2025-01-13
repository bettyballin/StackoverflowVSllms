import java.lang.String;

public class EnumMapper {
    public static void main(String[] args) {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.mapValue();
    }

    public void mapValue() {
        // Assuming dbQueryResult is an object that has a method getMyColumn()
        // For demonstration purposes, it's replaced with a hardcoded value
        String myValue = "Y"; // Replace with actual dbQueryResult.getMyColumn();
        String result;

        switch (myValue) {
            case "Y":
                result = "Yes";
                break;
            case "N":
                result = "No";
                break;
            default:
                result = "Unknown";
                break;
        }

        System.out.println(result);
    }
}