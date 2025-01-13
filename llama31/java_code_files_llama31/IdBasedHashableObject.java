/*
 * Decompiled with CFR 0.152.
 */
public class IdBasedHashableObject {
    private long id;

    public IdBasedHashableObject(long l) {
        this.id = l;
    }

    public int hashCode() {
        return (int)this.id;
    }

    public static void main(String[] stringArray) {
        IdBasedHashableObject idBasedHashableObject = new IdBasedHashableObject(123L);
        System.out.println(idBasedHashableObject.hashCode());
    }
}
