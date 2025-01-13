/*
 * Decompiled with CFR 0.152.
 */
private class MRUCache.Node {
    Object key;
    Object value;
    MRUCache.Node prev;
    MRUCache.Node next;

    MRUCache.Node(MRUCache mRUCache, Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }
}
