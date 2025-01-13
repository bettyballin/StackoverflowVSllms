import java.lang.String;

public class HibernateUtil {
    static {
        try {
            Class<?> clazz = HibernateUtil.class;
            System.out.println("Loading class: " + clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}