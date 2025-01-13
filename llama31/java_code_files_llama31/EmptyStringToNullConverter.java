/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.AttributeConverter
 *  javax.persistence.Converter
 */
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmptyStringToNullConverter
implements AttributeConverter<String, String> {
    public String convertToDatabaseColumn(String string) {
        return string == null || string.isEmpty() ? null : string;
    }

    public String convertToEntityAttribute(String string) {
        return string == null ? "" : string;
    }

    public static void main(String[] stringArray) {
        EmptyStringToNullConverter emptyStringToNullConverter = new EmptyStringToNullConverter();
        System.out.println(emptyStringToNullConverter.convertToDatabaseColumn(""));
        System.out.println(emptyStringToNullConverter.convertToDatabaseColumn("Hello"));
        System.out.println(emptyStringToNullConverter.convertToEntityAttribute(null));
        System.out.println(emptyStringToNullConverter.convertToEntityAttribute("World"));
    }
}
