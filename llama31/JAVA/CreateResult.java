import java.util.List;

public class CreateResult {
    public interface MyAccountService {
        CreateResult create(String user);

        public static class CreateResult {
            private boolean success;
            private List<String> errors;
            private String ldapError; // or any other specific error info

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public List<String> getErrors() {
                return errors;
            }

            public void setErrors(List<String> errors) {
                this.errors = errors;
            }

            public String getLdapError() {
                return ldapError;
            }

            public void setLdapError(String ldapError) {
                this.ldapError = ldapError;
            }
        }
    }

    public static void main(String[] args) {
    }
}