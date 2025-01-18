import java.util.List;
import java.util.ArrayList;
// Identify strong or weak references that can potentially cause a memory leak:
// Strong reference examples - static objects, event handlers, circular dependencies etc.
public class MyClassWithLeakIssue // replace with your actual problematic class name
{
    private List<String> _list; // strong referenced object

    public void MethodMayCauseALeak()
    {
        _list = new ArrayList<String>();
        _list.add("SomeData");
    }

    public static void main(String[] args) {
    }
}