public interface IMySyntax {
    IMySyntax myMethod1();
    IMySyntax myMethod2();
}

public class MyBuilder implements IMySyntax {
    public static IMySyntax build() { 
        return new MyBuilder(); 
    }
    
    @Override
    public IMySyntax myMethod1() { 
        // Implementation for myMethod1
        return this; 
    }

    @Override
    public IMySyntax myMethod2() { 
        // Implementation for myMethod2
        return this; 
    }     

    public static void main(String[] args) {
        // You can add code here to test your class if needed
    }
}