public class ErrorCodeMapper {
    public String getErrorMessages(int code) {
        String errorMessage;
        if (code >= 100 && code < 200) {
            if (code == 101) {
                errorMessage = "Invalid username";
            } else if (code == 102) {
                errorMessage = "Invalid password";
            } else {
                errorMessage = "Unknown error";
            }
        } else if (code >= 200 && code < 300) {
            if (code == 201) {
                errorMessage = "Database connection failed";
            } else if (code == 202) {
                errorMessage = "Invalid query";
            } else {
                errorMessage = "Unknown error";
            }
        } else {
            errorMessage = "Unknown error";
        }
        return errorMessage;
    }

    public static void main(String[] args) {
        ErrorCodeMapper mapper = new ErrorCodeMapper();
        System.out.println(mapper.getErrorMessages(101)); // test the method
    }
}