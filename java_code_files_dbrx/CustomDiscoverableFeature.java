import java.util.Set;
import java.lang.String;
import org.jivesoftware.smackx.disco.*;
import java.util.*;

public class CustomDiscoverableFeature implements DiscoverableInfo {
    private final static Set<String> FEATURES = Collections.singleton("custom:feature");

    @Override
    public Collection<String> getFeatures() {
        return FEATURES;
    }

    public static void main(String[] args) {
    }
}