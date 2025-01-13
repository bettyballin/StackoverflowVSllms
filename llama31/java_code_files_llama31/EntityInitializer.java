/*
 * Decompiled with CFR 0.152.
 */
public class EntityInitializer {
    public static void main(String[] stringArray) {
        EntityInitializer entityInitializer = new EntityInitializer();
        entityInitializer.init();
    }

    public void init() {
        MyObject myObject = new MyObject();
        Hibernate.initialize(myObject.getSomeCollection());
    }
}
