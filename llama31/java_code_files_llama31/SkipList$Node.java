/*
 * Decompiled with CFR 0.152.
 */
private static class SkipList.Node {
    int value;
    SkipList.Node[] next;

    SkipList.Node(int n) {
        this.value = n;
        this.next = new SkipList.Node[16];
    }
}
