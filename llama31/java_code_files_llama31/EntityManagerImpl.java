/*
 * Decompiled with CFR 0.152.
 */
class EntityManagerImpl
implements EntityManager {
    EntityManagerImpl() {
    }

    @Override
    public <T> T find(Class<T> clazz, Object object) {
        if (clazz == User.class && object.equals(1L)) {
            return clazz.cast(new User(1L, "John Doe"));
        }
        return null;
    }

    @Override
    public void persist(Object object) {
        System.out.println("Saving entity: " + String.valueOf(object));
    }
}
