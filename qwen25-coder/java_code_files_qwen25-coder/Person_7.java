public class Person {
    public String getName() { return null; } // default implementation
    public Float getSalary() { return null; } // default implementation
}

class Employee extends Person {
    private float salary = 0f;
    @Override
    public Float getSalary() { return this.salary; }
}