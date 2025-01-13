/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.ElementCollection
 *  javax.persistence.MapKeyColumn
 */
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MapKeyColumn;

public class ConfigurationItem {
    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    private Map<String, String> myMap;

    public static void main(String[] stringArray) {
    }
}
