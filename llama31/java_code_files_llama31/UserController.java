/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class UserController {
    private UserDao userDao = new UserDao();

    public List<UserViewBean> getUsersForScreen() {
        return this.userDao.getUsersWithDepartmentCount();
    }

    public static void main(String[] stringArray) {
        UserController userController = new UserController();
        List<UserViewBean> list = userController.getUsersForScreen();
        for (UserViewBean userViewBean : list) {
            System.out.println("User: " + userViewBean.getName() + ", Department Count: " + userViewBean.getDepartmentCount());
        }
    }
}
