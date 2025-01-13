import java.io.Serializable;
import java.util.UUID;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GuidGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object) {
        return UUID.randomUUID();
    }

    public static void main(String[] args) {
    }
}