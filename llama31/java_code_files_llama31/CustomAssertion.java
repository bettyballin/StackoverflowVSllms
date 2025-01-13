/*
 * Decompiled with CFR 0.152.
 */
public class CustomAssertion {
    public static void assertArrays(String[] stringArray, String[] stringArray2) {
        if (stringArray.length != stringArray2.length) {
            throw new AssertionError((Object)"Arrays are not the same length");
        }
        boolean[] blArray = new boolean[stringArray2.length];
        for (String string : stringArray) {
            boolean bl = false;
            for (int i = 0; i < stringArray2.length; ++i) {
                if (!string.equals(stringArray2[i]) || blArray[i]) continue;
                blArray[i] = true;
                bl = true;
                break;
            }
            if (!bl) {
                throw new AssertionError((Object)"Element not found in the expected array");
            }
        }
    }

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"a", "b", "c"};
        String[] stringArray3 = new String[]{"c", "b", "a"};
        try {
            CustomAssertion.assertArrays(stringArray2, stringArray3);
            System.out.println("Assertion passed");
        }
        catch (AssertionError assertionError) {
            System.out.println("Assertion failed: " + ((Throwable)((Object)assertionError)).getMessage());
        }
    }
}
