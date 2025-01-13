/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;

public class TimestampGenerator {
    private Date created;

    public Date created() {
        if (this.created == null) {
            this.created = new Date();
        }
        return this.created;
    }

    public static void main(String[] stringArray) {
        TimestampGenerator timestampGenerator = new TimestampGenerator();
        System.out.println(timestampGenerator.created());
    }
}
