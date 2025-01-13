/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class MultipartBoundaryGenerator {
    String boundary = "---------------------------" + UUID.randomUUID().toString();

    public static void main(String[] stringArray) {
    }
}
