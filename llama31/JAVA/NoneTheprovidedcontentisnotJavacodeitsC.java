public class Main {
    public static void main(String[] args) {
        String nom = "1";
        String ou = "2";
        if (nom.equals("1") || nom.equals("2") || nom.equals("3")) {
            ou = "3";
        } else if (nom.equals("4") || nom.equals("5") || nom.equals("6")) {
            ou = "4";
        } else if (nom.equals("7") || nom.equals("8") || nom.equals("9")) {
            ou = "5";
        } else if (nom.equals("10") || nom.equals("11") || nom.equals("12")) {
            ou = "6";
        } else {
            ou = "7";
        }
        System.out.println(ou);
    }
}