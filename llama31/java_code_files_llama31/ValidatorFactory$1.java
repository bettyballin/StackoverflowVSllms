/*
 * Decompiled with CFR 0.152.
 */
static class ValidatorFactory.1
implements AbstractValidator<T> {
    ValidatorFactory.1() {
    }

    @Override
    public boolean isValid(T t) {
        return t != null;
    }
}
