import java.lang.String;

public class User_11 {
    private String _name; // prefix with underscore
    private String userName; // or better approach, by adding a semantic noun/adjective for context.
    private int indexValue;  // here you are avoiding keyword `index` with `indexValue`.
    
    // or use getter and setter methods to access property using method name instead of the actual variable.
    public int getIndex(){
        return this.indexValue;
    }

    public static void main(String[] args) {
    }
}