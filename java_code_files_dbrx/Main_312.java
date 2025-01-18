import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import com.jc.spu.*;

public class Main_312 {
    public static void main(String[] args) {
        Parser p = new Parser();
        // register your classes and methods that you want to support in the parser
        Class<?> clazz = CreateUser.class;
        p.registerClass(clazz);
        for (Method m : clazz.getMethods()) {
            if (!Modifier.isPublic(m.getModifiers())) continue; // ignore non-public methods
            p.register(new Call<>(p, "\\b" + m.getName() + "\\b", m));
        }

        String input = "creaTe user user1 with email test@email.com and password test";
        List<CallResult> results = new ArrayList<>();
        p.parseInput(input).forEach(r -> { if (!"unknown".equalsIgnoreCase(r.getName())) results.add(r); });

        CreateUser created = null;
        for (CallResult r : results) {
            switch (r.getName().toLowerCase()) {
                case "createuser":
                    Object[] args1 = {r.getIntParam("userId")}; // the userId argument refers to user1 in your command sentence, but SPU does not support automatic conversions by default and would require additional configuration or handling
                    created = (CreateUser) r.getCallable().call(args1)[0];
                    break;
                case "withemail":
                    created.setEmail((String) r.getValue());
                    break;
                case "andpassword":
                    Object[] args2 = {r.getStringParam("password")}; // the password argument refers to test in your command sentence, but SPU does not support automatic conversions by default and would require additional configuration or handling
                    created.setPassword((String) r.getCallable().call(args2)[0]);
                    break;
            }
        }
     }
}

// Definition of Parser class
class Parser {
    public Parser() {
        // constructor
    }
    public void registerClass(Class<?> clazz) {
        // stub method
    }
    public void register(Call<?> call) {
        // stub method
    }
    public List<CallResult> parseInput(String input) {
        // return an empty list for now
        return new ArrayList<>();
    }
}

// Definition of Call class
class Call<T> {
    public Call(Parser p, String s, Method m) {
        // constructor
    }
    public Object[] call(Object... args) {
        // stub method
        return new Object[0];
    }
}

// Definition of CallResult class
class CallResult {
    public String getName() {
        // stub method
        return "";
    }
    public int getIntParam(String param) {
        // stub method
        return 0;
    }
    public String getStringParam(String param) {
        // stub method
        return "";
    }
    public Object getValue() {
        // stub method
        return null;
    }
    public Call<?> getCallable() {
        // stub method
        return null;
    }
}

// Definition of CreateUser class
class CreateUser {
    public void setEmail(String email) {
        // stub method
    }
    public void setPassword(String password) {
        // stub method
    }
}