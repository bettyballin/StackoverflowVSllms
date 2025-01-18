import java.util.List;

@interface Service {
}

class Locations {
    // Empty class representing Locations
}

interface LocationDAO {
    List<Locations> getAllLocation();
}

@Service
public class LocationDAOImpl implements LocationDAO {
    @Override // This method's results would be cached depending on the configuration defined
    public List<Locations> getAllLocation() {
        return null; // Placeholder implementation
    }
}