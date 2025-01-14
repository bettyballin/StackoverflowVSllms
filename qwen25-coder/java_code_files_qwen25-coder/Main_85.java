public class Main {
    public static void main(String[] args) {
        System.out.println("Plainttext: ");
        String passwort = "";
        int privatekey1 = 0;
        int key2 = 1;
        int[] Cipher = new int[0];
        int temp1, temp2, klartext;

        for (temp2 = 0; temp2 < passwort.length(); temp2++) {
            klartext = 1;
            for (temp1 = 0; temp1 < privatekey1; temp1++) {
                klartext = (klartext * Cipher[temp2]) % key2;
            }
            klartext = klartext % key2;
            System.out.print((char) klartext);
        }
        System.out.println();
    }
}