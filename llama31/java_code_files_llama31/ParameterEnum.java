/*
 * Decompiled with CFR 0.152.
 */
public class ParameterEnum {
    public static void main(String[] stringArray) {
    }

    public static enum Parameter {
        CTITLE("CTITLE", "T", 2731);

        private final String name;
        private final String type;
        private final int value;

        private Parameter(String string2, String string3, int n2) {
            this.name = string2;
            this.type = string3;
            this.value = n2;
        }
    }
}
