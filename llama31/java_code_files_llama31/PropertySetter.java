/*
 * Decompiled with CFR 0.152.
 */
public class PropertySetter {
    public void setProperty(Object object) {
        if (object == null) {
            throw new NullPointerException("Property cannot be null");
        }
    }

    public static void main(String[] stringArray) {
        PropertySetter propertySetter = new PropertySetter();
        propertySetter.setProperty("Test Property");
    }
}
