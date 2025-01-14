public class Main {
    static void modify(int num) {
        num += 1;
    }

    static class Wrapper { int val; }

    static void modifyObj(Wrapper wrapper) {
        wrapper.val += 1;
    }

    public static void main(String[] args) {
        int number = 5;
        modify(number); // number is still 5
        System.out.println("number is " + number); // Output: number is 5

        Wrapper wrapper = new Wrapper();
        wrapper.val = 5;
        modifyObj(wrapper); // wrapper.val is now 6
        System.out.println("wrapper.val is " + wrapper.val); // Output: wrapper.val is 6
    }
}