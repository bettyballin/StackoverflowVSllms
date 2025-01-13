/*
 * Decompiled with CFR 0.152.
 */
class CommentValidator
implements Validator {
    private WebRequest webRequest;

    public CommentValidator(WebRequest webRequest) {
        this.webRequest = webRequest;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
