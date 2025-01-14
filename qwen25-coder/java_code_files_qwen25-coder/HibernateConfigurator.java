import java.lang.String;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cache.spi.CacheDataDescription;

public class HibernateConfigurator {
    public static void main(String[] args) {
        // Initialize the ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .configure() // Loads hibernate.cfg.xml
            .build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(MyEntity.class);

        MetadataImplementor metadata = (MetadataImplementor) metadataSources.getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.buildSessionFactory(
            new StandardServiceRegistryBuilder(serviceRegistry)
                .applySetting("hibernate.cache.use_second_level_cache", "true")
                .applySetting("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory")
                .configure() // Loads hibernate.cfg.xml
                .build()
        );

        Cache cache = sessionFactory.getCache();
        if (null != cache) {
            CacheDataDescription cdd = new CacheDataDescriptionImpl(false, true, null);
            cache.getNaturalIdCacheAccessStrategy(MyEntity.class).getCache().put(new SimpleKey(null), "value", cdd);
        }
    }
}

// Dummy class definitions to make the code executable
class MyEntity {
    // Define entity fields and methods here
}

class SimpleKey {
    public SimpleKey(Object key) {
        // Constructor implementation
    }
}

class CacheDataDescriptionImpl implements CacheDataDescription {
    public CacheDataDescriptionImpl(boolean mutable, boolean versioned, Object versionComparator) {
        // Constructor implementation
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public boolean isVersioned() {
        return false;
    }

    @Override
    public java.util.Comparator getVersionComparator() {
        return null;
    }
}