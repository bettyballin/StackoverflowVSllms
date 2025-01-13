/*
 * Decompiled with CFR 0.152.
 */
class Allocation {
    private int eventId;
    private int allocationId;
    private int size;

    public Allocation(int n, int n2, int n3) {
        this.eventId = n;
        this.allocationId = n2;
        this.size = n3;
    }

    public int getEventId() {
        return this.eventId;
    }

    public int getAllocationId() {
        return this.allocationId;
    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] stringArray) {
    }
}
