import java.lang.String;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Repository {
}

class JpaDaoSupport {
    // Use getEntityManager() to interact with EntityManager

    public Object getEntityManager() {
        // Method stub
        return null;
    }
}

interface Dao {
    // Interface methods (if any)
}

@Repository
public class JpaDaoImpl extends JpaDaoSupport implements Dao {
    // Use getEntityManager() to interact with EntityManager

	public static void main(String[] args) {
	}
}