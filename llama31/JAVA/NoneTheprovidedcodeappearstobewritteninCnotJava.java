public class Main {
    public static void main(String[] args) {
        String nom;
        String ou;
        nom = "1";
        if (nom.equals("1")) {
            nom += "1";
            ou = nom;
        } else {
            ou = null; // or some default value
        }
        System.out.print(ou);
    }
}