/*
 * Decompiled with CFR 0.152.
 */
public class StringConcatBenchmark {
    public static void main(String[] stringArray) {
        int n = 100000;
        String string = "https://example.com";
        long l = System.nanoTime();
        for (int i = 0; i < n; ++i) {
            String string2 = "<a href='" + string + "'>click here</a>";
        }
        long l2 = System.nanoTime();
        System.out.println("Time taken using + operator: " + (l2 - l) + " ns");
        l = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            stringBuffer.setLength(0);
            stringBuffer.append("<a href='").append(string).append("'>click here</a>");
        }
        l2 = System.nanoTime();
        System.out.println("Time taken using StringBuffer: " + (l2 - l) + " ns");
    }
}
