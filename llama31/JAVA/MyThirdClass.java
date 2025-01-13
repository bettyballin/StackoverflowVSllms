public class MyThirdClass {
    private final String componentB;

    public MyThirdClass(String componentB) {
        this.componentB = componentB;
    }

    public static void main(String[] args) {
        MyThirdClass myThirdClass = new MyThirdClass("Example Component B");
        System.out.println("Created MyThirdClass instance with componentB: " + myThirdClass.componentB);
    }
}