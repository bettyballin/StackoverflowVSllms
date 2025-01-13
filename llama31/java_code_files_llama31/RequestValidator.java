/*
 * Decompiled with CFR 0.152.
 */
public class RequestValidator {
    public static void main(String[] stringArray) {
        String string = "state1,state2,state3";
        String string2 = "size1,size2,size3";
        String[] stringArray2 = string.split(",");
        String[] stringArray3 = string2.split(",");
        for (String string3 : stringArray2) {
            System.out.println("State: " + string3.trim());
        }
        for (String string3 : stringArray3) {
            System.out.println("Size: " + string3.trim());
        }
    }
}
