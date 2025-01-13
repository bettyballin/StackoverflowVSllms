import java.util.List;

// Assuming you have these classes in your Java project
import myjavaapp.MyModel;
import myjavaapp.MyDbContext;

public class MyJavaApp {
    public static void main(String[] args) {
        // Use the shared Java code
        MyDbContext context = new MyDbContext();
        List<MyModel> myModels = context.getMyModels();

        // Print the results
        for (MyModel model : myModels) {
            System.out.println(model.getName());
        }
    }
}