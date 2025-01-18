public class Main {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        if (object.getField().toLowerCase().contains("search string".toLowerCase())) {
            System.out.println("The field contains the search string.");
        } else {
            System.out.println("The field does not contain the search string.");
        }
    }
}

class MyObject {
    public String getField() {
        return "This is a sample field containing the Search String.";
    }
}