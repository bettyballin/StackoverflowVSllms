/*
 * Decompiled with CFR 0.152.
 */
public class ErrorMessageResolver {
    public String getErrorMessages(int n) {
        switch (n) {
            case 101: {
                return "Invalid username";
            }
            case 102: {
                return "Invalid password";
            }
            case 201: {
                return "Database connection failed";
            }
            case 202: {
                return "Invalid query";
            }
        }
        return "Unknown error";
    }

    public static void main(String[] stringArray) {
        ErrorMessageResolver errorMessageResolver = new ErrorMessageResolver();
        System.out.println(errorMessageResolver.getErrorMessages(101));
        System.out.println(errorMessageResolver.getErrorMessages(102));
        System.out.println(errorMessageResolver.getErrorMessages(201));
        System.out.println(errorMessageResolver.getErrorMessages(202));
        System.out.println(errorMessageResolver.getErrorMessages(500));
    }
}
