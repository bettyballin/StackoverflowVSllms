/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class Main_830 {
    public static void main(String[] stringArray) {
        Evaluator evaluator = new Evaluator();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("x", 10);
        Literal literal = new Literal(5);
        Variable variable = new Variable("x");
        System.out.println(evaluator.eval(literal, hashMap));
        System.out.println(evaluator.eval(variable, hashMap));
    }
}
