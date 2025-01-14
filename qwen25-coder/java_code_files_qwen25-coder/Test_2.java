import java.lang.String;
public class Test_2 {
    class Test {
        private int privateInt;

        public Test(int value) {
            this.privateInt = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Test)) return false;
            Test other = (Test) obj;
            return other.privateInt == privateInt; // Accessing private field of another instance within the same class.
        }
    }
    public static void main(String[] args) {
    }
}