import java.util.Map;
import java.lang.String;

public interface DataMapper<T, U> {
    T mapToObject(U u);
    U mapFromObject(T t);
}

public class UserBO {
    // Some properties and methods...
}

public class DBUser {
    // Some properties and methods...
}

public class UserDataMapper implements DataMapper<UserBO, DBUser> {
    public UserBO mapToObject(DBUser dbUser) {
        // Map properties from dbUser to userBO and return...
        return new UserBO();
    }
    @Override
    public DBUser mapFromObject(UserBO businessObj) {
       // Map properties from userBO to dbUser and return...
       return new DBUser();
    }

    public static void main(String[] args) {
        // You can create an instance of UserDataMapper and test it
        UserDataMapper mapper = new UserDataMapper();
        UserBO userBO = mapper.mapToObject(new DBUser());
        DBUser dbUser = mapper.mapFromObject(new UserBO());
    }
}