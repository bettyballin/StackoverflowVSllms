/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

static class Main_61.1
implements Comparator<Cat> {
    Main_61.1() {
    }

    @Override
    public int compare(Cat cat, Cat cat2) {
        return cat.getBirthday().compareTo(cat2.getBirthday());
    }
}
