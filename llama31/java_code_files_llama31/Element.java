/*
 * Decompiled with CFR 0.152.
 */
class Element {
    private int id;
    private int parent;

    public int getId() {
        return this.id;
    }

    public int getParent() {
        return this.parent;
    }

    public Element(int n, int n2) {
        this.id = n;
        this.parent = n2;
    }
}
