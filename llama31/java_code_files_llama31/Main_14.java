/*
 * Decompiled with CFR 0.152.
 */
public class Main_14 {
    public static Object getLastElement(Object[] objectArray) {
        return objectArray[objectArray.length - 1];
    }

    public static void main(String[] stringArray) {
        Object[] objectArray = new Object[]{1, 2, 3, 4, 5};
        System.out.println(Main_14.getLastElement(objectArray));
    }
}
