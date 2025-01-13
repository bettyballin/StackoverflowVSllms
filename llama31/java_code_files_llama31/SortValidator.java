/*
 * Decompiled with CFR 0.152.
 */
public class SortValidator {
    public static void main(String[] stringArray) {
        String string = "field1:asc,field2:desc";
        SortValidator.validateSort(string);
    }

    public static void validateSort(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            String[] stringArray2 = string2.split(":");
            if (stringArray2.length != 2) {
                throw new RuntimeException("Invalid sort format");
            }
            String string3 = stringArray2[0];
            String string4 = stringArray2[1];
            if (!string3.matches("[a-zA-Z_][a-zA-Z_0-9]*") || !string4.matches("asc|desc")) {
                throw new RuntimeException("Invalid sort field or direction");
            }
            System.out.println("Validated field: " + string3 + ", direction: " + string4);
        }
    }
}
