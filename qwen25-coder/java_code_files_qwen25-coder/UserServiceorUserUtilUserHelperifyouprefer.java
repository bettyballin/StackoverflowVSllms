import java.lang.String;
public class UserServiceorUserUtilUserHelperifyouprefer {

    public User updateUserAge(User user, int newAge) {
        return new User(user.name, newAge);
    }

    public static void main(String[] args) {
    }

}

class User {
    public String name;
    public int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}