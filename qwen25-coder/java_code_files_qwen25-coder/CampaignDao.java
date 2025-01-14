import java.util.List;

public class CampaignDao {
    public interface CampaignRepository {
        void save(Campaign campaign);
        void delete(Campaign campaign);
        Campaign getById(String id);
        List<Campaign> getAll();
        // additional methods as necessary
    }

    public static void main(String[] args) {
    }
}

class Campaign {
    // minimal implementation
}