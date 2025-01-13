import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.util.Collections;

public class Main_694 {
    public static void main(String[] args) {
        CategoryCountManager categoryCountManager = new CategoryCountManager();
        Hashtable<String, Hashtable<String, Integer>> hash = 
            categoryCountManager.getFunctionWithSubFunctionCount(1L);

        Set<String> functions = hash.keySet();
        for (String fun : functions) {
            System.out.println("***************************");
            System.out.println(fun);
            System.out.println("***************************");
            Hashtable<String, Integer> obj = hash.get(fun);
            Vector<String> v = new Vector<String>(obj.keySet());
            Collections.sort(v);
            for (String str : v) {
                System.out.println("#" + str + "-" + obj.get(str));
            }
        }
    }
}

class CategoryCountManager {
    public Hashtable<String, Hashtable<String, Integer>> getFunctionWithSubFunctionCount(long id) {
        // Example implementation
        Hashtable<String, Hashtable<String, Integer>> result = new Hashtable<String, Hashtable<String, Integer>>();
        Hashtable<String, Integer> subFunctions = new Hashtable<String, Integer>();
        subFunctions.put("subFunction1", 1);
        subFunctions.put("subFunction2", 2);
        result.put("function1", subFunctions);
        return result;
    }
}