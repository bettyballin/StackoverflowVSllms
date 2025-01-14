package syntaxtest;

public class Main_82 {
    public static void main(String[] args) {
        MyTest tester = new MyTest() {
            {
                // Creating an instance initializer block to set the name
                setName("John Johnson");
            }
        };
        System.out.println(tester.getName()); // Output: John Johnson
    }
}

class MyTest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}