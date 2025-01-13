public class None_65_65 {
    public static void main(String[] args) {
        String nom = "1";
        String ou;
        if (nom.equals("1")) {
            ou = "2";
        } else {
            ou = null; // or some default value
        }
        System.out.println(ou);
    }
}