/*
 * Decompiled with CFR 0.152.
 */
class ExternalResourceBundle {
    private String bundleName;
    private String path;

    public ExternalResourceBundle(String string, String string2) {
        this.bundleName = string;
        this.path = string2;
    }

    public String getString(String string) {
        return "Some value";
    }
}
