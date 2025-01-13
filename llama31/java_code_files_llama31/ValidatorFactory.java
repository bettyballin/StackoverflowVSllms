/*
 * Decompiled with CFR 0.152.
 */
class ValidatorFactory {
    ValidatorFactory() {
    }

    public static <T> AbstractValidator<T> getValidator(T t) {
        return new AbstractValidator<T>(){

            @Override
            public boolean isValid(T t) {
                return t != null;
            }
        };
    }
}
