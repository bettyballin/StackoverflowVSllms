/*
 * Decompiled with CFR 0.152.
 */
public class RepresentationFactory {
    Representation representation;

    public RepresentationFactory(String string) {
        this.representation = new StringRepresentation(string, MediaType.TEXT_PLAIN);
    }

    public static void main(String[] stringArray) {
    }
}
