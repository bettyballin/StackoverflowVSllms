/*
 * Decompiled with CFR 0.152.
 */
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

public class Main_69 {
    public static void main(String[] stringArray) {
        BasicAttributes basicAttributes = new BasicAttributes();
        BasicAttribute basicAttribute = new BasicAttribute("description");
        basicAttribute.add("This is the first description");
        basicAttribute.add("This is the second description");
        basicAttributes.put(basicAttribute);
    }
}
