/*
 * Decompiled with CFR 0.152.
 */
class Entity {
    private int id;
    private String name;
    private String value;

    public Entity(int n, String string, String string2) {
        this.id = n;
        this.name = string;
        this.value = string2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
