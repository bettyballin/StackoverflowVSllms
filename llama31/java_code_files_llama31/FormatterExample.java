/*
 * Decompiled with CFR 0.152.
 */
public class FormatterExample {
    String template = "%02d";
    String result = String.format(this.template, 5);

    public static void main(String[] stringArray) {
        FormatterExample formatterExample = new FormatterExample();
        System.out.println(formatterExample.result);
    }
}
