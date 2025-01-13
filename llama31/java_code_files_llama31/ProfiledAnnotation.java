/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ProfiledAnnotation {
    public static void main(String[] stringArray) {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    public static @interface Profiled {
        public String value();
    }
}
