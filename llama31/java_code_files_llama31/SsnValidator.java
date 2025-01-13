/*
 * Decompiled with CFR 0.152.
 */
public class SsnValidator
implements Validator {
    public boolean supports(Class<?> clazz) {
        return SSN.class.equals(clazz);
    }

    public void validate(Object object, Errors errors) {
        SSN sSN = (SSN)object;
        if (!this.isValid(sSN)) {
            errors.rejectValue("person.ssn", "invalid.ssn.reason", "Invalid SSN reason");
        }
    }

    private boolean isValid(SSN sSN) {
        return sSN.getNumber().matches("\\d{9}");
    }

    public static void main(String[] stringArray) {
        SSN sSN = new SSN("123456789");
        SsnValidator ssnValidator = new SsnValidator();
        Errors errors = new Errors();
        if (ssnValidator.supports(SSN.class)) {
            ssnValidator.validate(sSN, errors);
        }
    }
}
