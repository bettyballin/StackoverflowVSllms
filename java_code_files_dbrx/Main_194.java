// To compile this code, you need to have the Jackson library.
// Download the Jackson Databind JAR (e.g., jackson-databind-2.15.0.jar) from:
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
//
// Compile the code with:
// javac -cp jackson-databind-2.15.0.jar Main.java
//
// Run the program with:
// java -cp .:jackson-databind-2.15.0.jar Main

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {

        Employee emp = new Employee();
        emp.name  = "John";
        emp.age   = 34;
        emp.salary = 6700;

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(emp);
        System.out.println(jsonInString);
    }
}

class Employee {
    public String name;
    public int age;
    public double salary;
}