/*
 * Decompiled with CFR 0.152.
 */
class UserRepositoryImpl
implements UserRepository {
    private final EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getUserById(Long l) {
        return this.entityManager.find(User.class, l);
    }

    @Override
    public void saveUser(User user) {
        this.entityManager.persist(user);
    }

    public static void main(String[] stringArray) {
        EntityManagerImpl entityManagerImpl = new EntityManagerImpl();
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(entityManagerImpl);
        User user = userRepositoryImpl.getUserById(1L);
        System.out.println("Found User: " + user.getName());
        User user2 = new User(2L, "Jane Doe");
        userRepositoryImpl.saveUser(user2);
    }
}
