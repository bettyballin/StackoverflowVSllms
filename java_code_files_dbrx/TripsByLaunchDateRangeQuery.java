import java.lang.String;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

public class TripsByLaunchDateRangeQuery {

    private EntityManager em;
    private Range range;

    public TripsByLaunchDateRangeQuery() {
        Query q = em.createNativeQuery(
            "select T.* from Trip T join Itinerary I on (T.itinerary_id=I.id) where I.launchDate between :start and :end or ADDDATE(I.launchDate, I.equipmentPullDayOfTrips) between :start and :end",
            "TripsResults" );
        q.setParameter("start", range.getStart(), TemporalType.DATE);
        q.setParameter("end", range.getEnd(), TemporalType.DATE);
    }

    public static void main(String[] args) {
    }
}

class Range {
    public Date getStart() { return null; }
    public Date getEnd() { return null; }
}