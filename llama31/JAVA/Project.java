import java.lang.String;

public class Project {
    private int projectId;
    private String projectName;
    // Other project fields
    
    // Foreign key relationship
    private Company company;

    // Constructors, getters, and setters
    public Project() {}
    
    public Company getCompany() {
        return company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
}

class Company {
    private int companyId;
    private String companyName;
    // Other company fields
    
    // Constructors, getters, and setters

    public static void main(String[] args) {
    }
}