/*
 * Decompiled with CFR 0.152.
 */
public class CatValidatorFactoryExample {
    public static void main(String[] stringArray) {
        Cat cat = new Cat();
        AbstractValidator<Cat> abstractValidator = ValidatorFactory.getValidator(cat);
        System.out.println("Is cat valid? " + abstractValidator.isValid(cat));
    }
}
