import java.lang.String;
public class EmployeeChecker {
    public boolean hasSalaryProperty() {
        return (this instanceof Employee);
    }

    public static void main(String[] args) {
    }
}

class Employee {
}