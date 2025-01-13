/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

class ObjectSet
implements Iterable<Object> {
    ObjectSet() {
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>(this){

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
