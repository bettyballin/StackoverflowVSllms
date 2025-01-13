/*
 * Decompiled with CFR 0.152.
 */
public class CommentValidatorFactory
implements ValidatorFactory {
    public Validator getValidator(WebRequest webRequest) {
        return new CommentValidator(webRequest);
    }

    public static void main(String[] stringArray) {
        CommentValidatorFactory commentValidatorFactory = new CommentValidatorFactory();
        WebRequest webRequest = new WebRequest();
        Validator validator = commentValidatorFactory.getValidator(webRequest);
        System.out.println(validator.validate());
    }
}
