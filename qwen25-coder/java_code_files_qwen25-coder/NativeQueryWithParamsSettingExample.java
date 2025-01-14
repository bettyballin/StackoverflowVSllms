import java.util.Date;

public class NativeQueryWithParamsSettingExample {

    EntityManager em;
    Range range;

    {
        Query q = em.createNativeQuery(
            "select T.* " +
            "from Trip T join Itinerary I on (T.itinerary_id=I.id) " +
            "where I.launchDate between :start and :end " +
            "or ADDDATE(I.launchDate, I.equipmentPullDayOfTrip) between :start and :end",
            "TripResults" // or "CommercialTripResults" depending on your needs
        );

        q.setParameter("start", range.getStart(), TemporalType.DATE);
        q.setParameter("end", range.getEnd(), TemporalType.DATE);
    }

    public static void main(String[] args) {
    }
}

class EntityManager {
    public Query createNativeQuery(String sqlString, String resultSetMapping) {
        return new Query();
    }
}

class Query {
    public Query setParameter(String name, Object value, TemporalType temporalType) {
        return this;
    }
}

enum TemporalType {
    DATE
}

class Range {
    public Date getStart() {
        return new Date();
    }

    public Date getEnd() {
        return new Date();
    }
}