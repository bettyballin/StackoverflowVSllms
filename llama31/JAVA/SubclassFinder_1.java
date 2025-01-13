import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;

import org.reflections.Reflections;

public class SubclassFinder_1_1 {
    public static List<Class<?>> getSubclasses(Class<?> clazz) {
        Reflections reflections = new Reflections("my.package");
        return reflections.getSubTypesOf(clazz);
    }

	public static void main(String[] args) {
	}
}