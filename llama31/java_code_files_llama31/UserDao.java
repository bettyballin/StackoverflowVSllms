/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

interface UserDao {
    public List<User> getAllUsers();

    public User getUserById(Long var1);

    public void saveUser(User var1);
}
