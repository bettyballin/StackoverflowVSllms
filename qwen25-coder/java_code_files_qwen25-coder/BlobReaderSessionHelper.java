import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.sql.Blob;

public class BlobReaderSessionHelper {

    public static void main(String[] args) {
        // In a real application, configure the SessionFactory properly
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Assuming 'yourEntity' is the entity containing the BLOB
            int entityId = 1; // Example entity ID
            YourEntity yourEntity = (YourEntity) session.get(YourEntity.class, entityId);
            if (yourEntity != null && yourEntity.getBlobColumn() != null) {
                InputStream inputStream = yourEntity.getBlobColumn().getBinaryStream();
                // Process or read the input stream here
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    // Handle data (e.g., write to file, process bytes)
                }
                inputStream.close(); // Don't forget to close the stream
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}

class YourEntity {
    public Blob getBlobColumn() {
        return null; // Replace with actual implementation
    }
}