import java.lang.String;

public class EmployeeAgreementManager {
    // Example: Contract signature tracking system (conceptual).
    Employee employee = new Employee();
    {
       Agreement agreement = new NDA(employee);
       if (!employee.signAgreement(agreement)) {
           terminateContractProcess(employee);
       }
    }

    public static void main(String[] args) {
    }

    void terminateContractProcess(Employee employee) {
        // Implementation here
    }
}

class Employee {
    boolean signAgreement(Agreement agreement) {
        // For compiling purposes, return true
        return true;
    }
}

class Agreement {
    Employee employee;
    public Agreement(Employee employee) {
        this.employee = employee;
    }
}

class NDA extends Agreement {
    public NDA(Employee employee) {
        super(employee);
    }
}