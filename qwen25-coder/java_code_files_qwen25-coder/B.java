import java.lang.String;

public class B {
    public B() {}
    
    public B(int param) { 
        // Initialization code here
    }
    
    class S extends B {
        // Constructor calling the one-param constructor of B
        public S(int param) {
            super(param);  // Explicit call to B's constructor
        }
    }
    
    public static void main(String[] args) {
    }
}