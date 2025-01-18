import java.lang.String;

public class DetachedEntityManagerUtil {

    EntityManager em;

    void someMethodThatNeedsDetachedObj(MyJpaEntity jpaEntity) {
        // ... other codes above

        em.detach(jpaEntity);

        // Now the passed-in jpaEntity will not be affected by em calls (except on detachment it's already persisted in this transaction which isn't our case).
    }

    public static void main(String[] args) {
    }
}

class MyJpaEntity {
    // Empty class
}

class EntityManager {
    void detach(MyJpaEntity entity) {
        // dummy implementation
    }
}