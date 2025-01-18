import java.util.Map;

public class DogRule implements RuleEvaluator {
   public boolean evaluate(Object context) {
     // extract necessary data from 'context' which is typically a Map<String, Object>
     String entityName = (String) ((Map<String, Object>) context).get("entityName");
     return "Dog".equalsIgnoreCase(entityName);
  }

	public static void main(String[] args) {
	}
}

interface RuleEvaluator {
    boolean evaluate(Object context);
}