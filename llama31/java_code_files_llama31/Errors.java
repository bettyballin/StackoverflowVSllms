/*
 * Decompiled with CFR 0.152.
 */
class Errors {
    Errors() {
    }

    public void rejectValue(String string, String string2, String string3) {
        System.out.println("Validation error in field: " + string + ", with error code: " + string2 + ", and message: " + string3);
    }
}
