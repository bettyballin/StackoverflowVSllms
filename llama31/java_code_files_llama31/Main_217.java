/*
 * Decompiled with CFR 0.152.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main_217 {
    public static void main(String[] stringArray) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        Person person = new Person("John", "Doe");
        scriptEngine.put("person", person);
        String string = "person.setFirstName('Jane'); person.setLastName('Smith');";
        scriptEngine.eval(string);
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
    }
}
