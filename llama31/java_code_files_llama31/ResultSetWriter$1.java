/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

static class ResultSetWriter.1
implements Comparator<String[]> {
    ResultSetWriter.1() {
    }

    @Override
    public int compare(String[] stringArray, String[] stringArray2) {
        return stringArray[0].compareTo(stringArray2[0]);
    }
}
