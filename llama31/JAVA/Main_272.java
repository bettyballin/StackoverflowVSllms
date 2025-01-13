import java.lang.String;

public class Main_272_272 {
    public static void main(String[] args) {
        String className = Main_272.class.getName();
        String classPath = Main_272.class.getResource(className.replace('.', '/') + ".class").getPath();
        System.out.println(classPath);
    }
}