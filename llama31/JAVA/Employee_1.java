// Define a class
public class Employee_1 {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        // Create an object
        Employee emp = new Employee("John Doe", 30);
        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
    }
}