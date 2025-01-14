import java.lang.String;
import java.lang.Map;
import java.lang.annotation.*;

@DealTypeConverter.Converter(autoApply = true)
public class DealTypeConverter implements DealTypeConverter.AttributeConverter<DealTypeConverter.DealType, Long> {

    @Override
    public Long convertToDatabaseColumn(DealType attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case BASE:
                return 2L; // Assume 2 is the ID for "Base" in your DEAL_TYPE table
            case EXTRA:
                return 5L; // Assume 5 is the ID for "Extra" in your DEAL_TYPE table
            default:
                throw new IllegalArgumentException("Unknown deal type: " + attribute);
        }
    }

    @Override
    public DealType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData.intValue()) {
            case 2:
                return DealType.BASE; // Map ID 2 to BASE enum
            case 5:
                return DealType.EXTRA; // Map ID 5 to EXTRA enum
            default:
                throw new IllegalArgumentException("Unknown deal type ID: " + dbData);
        }
    }

    public static void main(String[] args) {
    }

    public static enum DealType {
        BASE,
        EXTRA;
    }

    public static interface AttributeConverter<X, Y> {
        Y convertToDatabaseColumn(X attribute);
        X convertToEntityAttribute(Y dbData);
    }

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Converter {
        boolean autoApply() default false;
    }
}