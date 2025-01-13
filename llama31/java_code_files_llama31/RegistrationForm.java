/*
 * Decompiled with CFR 0.152.
 */
public class RegistrationForm {
    private int attendees;

    public void register(int n) throws InvalidInputException {
        if (n < 1 || n > 10) {
            throw new InvalidInputException("Attendees must be between 1 and 10");
        }
    }

    public static void main(String[] stringArray) {
        RegistrationForm registrationForm = new RegistrationForm();
        try {
            registrationForm.register(5);
        }
        catch (InvalidInputException invalidInputException) {
            System.out.println(invalidInputException.getMessage());
        }
    }
}
