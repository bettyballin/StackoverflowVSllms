public class Test_14_14 {
    class Test {
        private int privateInt;

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Test t = (Test) obj;
            // Using a getter method to access private member of another instance
            return t.getPrivateInt() == privateInt;
        }

        public int getPrivateInt() {
            return privateInt;
        }

        public void setPrivateInt(int privateInt) {
            this.privateInt = privateInt;
        }
    }

    public static void main(String[] args) {
        Test_14 outer = new Test_14();
        Test_14.Test test1 = outer.new Test();
        test1.setPrivateInt(10);
        Test_14.Test test2 = outer.new Test();
        test2.setPrivateInt(10);
        System.out.println(test1.equals(test2)); // Should print: true
    }
}