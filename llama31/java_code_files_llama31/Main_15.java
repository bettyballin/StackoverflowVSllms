/*
 * Decompiled with CFR 0.152.
 */
public class Main_15 {
    public static void main(String[] stringArray) {
        Aka[] akaArray = new Aka[]{new Aka("en", "English Title"), new Aka("es", "Spanish Title")};
        String string = null;
        if (akaArray != null && akaArray.length > 0) {
            for (Aka aka : akaArray) {
                if (!aka.getLang().equals("es")) continue;
                string = aka.getTitle();
            }
        }
        System.out.println(string);
    }
}
