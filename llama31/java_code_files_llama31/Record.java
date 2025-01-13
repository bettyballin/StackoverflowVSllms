/*
 * Decompiled with CFR 0.152.
 */
class Record {
    private int id;
    private String name;
    private String surname;

    public Record(int n, String string, String string2) {
        this.id = n;
        this.name = string;
        this.surname = string2;
    }

    public String getName() {
        return this.name;
    }
}
