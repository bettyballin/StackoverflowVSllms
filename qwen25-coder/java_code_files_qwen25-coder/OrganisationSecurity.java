import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class OrganisationSecurity {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public OrganisationSecurity(UserRepository userRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    public boolean canView(Organisation organisation, User user) {
        // Check if the user is a member of a team that manages the organisation
        return teamRepository.findTeamByUser(user)
                             .map(team -> team.getManagedOrganisations().contains(organisation))
                             .orElse(false);
    }

    public boolean canEdit(Organisation organisation, User user) {
        // Additional checks might be necessary here depending on your use case
        return canView(organisation, user) && userRepository.isAccountManager(user.getId());
    }

    public static void main(String[] args) {
        // Example usage
        UserRepository userRepository = new UserRepository();
        TeamRepository teamRepository = new TeamRepository();
        OrganisationSecurity orgSecurity = new OrganisationSecurity(userRepository, teamRepository);

        Organisation organisation = new Organisation();
        User user = new User();

        boolean canUserView = orgSecurity.canView(organisation, user);
        boolean canUserEdit = orgSecurity.canEdit(organisation, user);

        System.out.println("Can view: " + canUserView);
        System.out.println("Can edit: " + canUserEdit);
    }
}

class User {
    private int id = 1;

    public int getId() {
        return id;
    }
}

class Organisation {
    // Organisation properties and methods
}

class UserRepository {
    public boolean isAccountManager(int userId) {
        // Dummy implementation
        return true;
    }
}

class TeamRepository {
    public Optional<Team> findTeamByUser(User user) {
        // Dummy implementation
        return Optional.of(new Team());
    }
}

class Team {
    public List<Organisation> getManagedOrganisations() {
        // Dummy implementation
        return new ArrayList<>();
    }
}