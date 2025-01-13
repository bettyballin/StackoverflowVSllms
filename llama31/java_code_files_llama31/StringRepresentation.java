/*
 * Decompiled with CFR 0.152.
 */
class StringRepresentation
implements Representation {
    private String jsonData;
    private MediaType mediaType;

    public StringRepresentation(String string, MediaType mediaType) {
        this.jsonData = string;
        this.mediaType = mediaType;
    }
}
