public class VariableReuseExample {
    void methodName() {
        int i = 7;
        for (int j = 0; j < 10; j++) {
            i = j * 2; // this will not declare new variable but instead assign value to already existing 'i'
        }
    }

    public static void main(String[] args) {
    }
}