import java.util.List;
import java.lang.reflect.*;

public class Test_8 {
    public static void main(String[] args) throws Exception {
        for (Field f : Test_8.class.getDeclaredFields()) {
            System.out.println("Field: " + f);
            Type type = f.getGenericType();
            if (type instanceof ParameterizedType) { // it's important to check the class of 'type', otherwise one would get ClassCastException
                for (Type t : ((ParameterizedType) type).getActualTypeArguments())
                    System.out.println("\tArgument: " + t);
            } else if (type instanceof TypeVariable) {
                for (Type t : ((TypeVariable<?>) type).getBounds())
                    System.out.println("\tBound: " + t);
            }
        }
    }

    List<String> list;
}