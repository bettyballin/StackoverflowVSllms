/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class RuleEvaluatorExample {
    public static void main(String[] stringArray) {
        Context context = new Context();
        context.setDog(new Dog("Fido", true));
        context.setArea("park");
        ArrayList<Rule> arrayList = new ArrayList<Rule>();
        arrayList.add(new DogCollarRule());
        RuleEngine ruleEngine = new RuleEngine(arrayList);
        ruleEngine.evaluate(context);
    }
}
