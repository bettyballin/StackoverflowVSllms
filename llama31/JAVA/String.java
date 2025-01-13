public class CustomString {
    private char[] value;
    private int hash;

    public CustomString(String str) {
        this.value = str.toCharArray();
        this.hash = 0;
    }

    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + value[i];
            }
            hash = h;
        }
        return h;
    }

    public static void main(String[] args) {
        CustomString str = new CustomString("Hello World");
        System.out.println(str.hashCode());
    }
}