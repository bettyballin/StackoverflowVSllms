import java.util.ArrayList;
import java.util.List;

public class ExpressionApplierorArgumentVisitor {

    Node node;

    {
       List<PExp> copy = new ArrayList<PExp>(node.getArgs());
       for(PExp e : copy)
       {
           e.apply(this);
       }
   }

	public static void main(String[] args) {
	}
}

class Node {
    public List<PExp> getArgs() {
        return new ArrayList<PExp>();
    }
}

class PExp {
    public void apply(Object o) {
    }
}