import java.io.InputStream;

public class MyClass {
    public static void main(String[] args) {
        MyClass myClassInstance = new MyClass();
        myClassInstance.myMethod();
    }

    public void myMethod() {
        // Retrieve the input stream for ReportQuery1.sql
        InputStream reportQuery1Input = getClass().getClassLoader().getResourceAsStream("com/example/report/ReportGeneratorSql/ReportQuery1.sql");
        //...
    }
}