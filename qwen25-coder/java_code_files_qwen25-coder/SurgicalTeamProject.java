import java.lang.String;
interface Surgeon {
    void performSurgery();
}

class LeadDeveloper implements Surgeon {
    @Override
    public void performSurgery() {
        System.out.println("Doing critical part of development.");
    }
}

class SupportTeamMember {
    public void assist() {
        System.out.println("Providing support in testing/documentation.");
    }
}

public class SurgicalTeamProject {
    public static void main(String[] args) {
        Surgeon leadDeveloper = new LeadDeveloper();
        SupportTeamMember qaEngineer = new SupportTeamMember();

        // Simulate a surgery
        leadDeveloper.performSurgery();

        // Simulate support work
        qaEngineer.assist();
    }
}