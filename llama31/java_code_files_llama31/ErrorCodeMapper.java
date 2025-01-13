/*
 * Decompiled with CFR 0.152.
 */
public class ErrorCodeMapper {
    public String getErrorMessages(int n) {
        String string = n >= 100 && n < 200 ? (n == 101 ? "Invalid username" : (n == 102 ? "Invalid password" : "Unknown error")) : (n >= 200 && n < 300 ? (n == 201 ? "Database connection failed" : (n == 202 ? "Invalid query" : "Unknown error")) : "Unknown error");
        return string;
    }

    public static void main(String[] stringArray) {
        ErrorCodeMapper errorCodeMapper = new ErrorCodeMapper();
        System.out.println(errorCodeMapper.getErrorMessages(101));
    }
}
