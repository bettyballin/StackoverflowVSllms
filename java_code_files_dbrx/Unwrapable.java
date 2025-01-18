public class Unwrapable {
    public static void main(String[] args) {
        try (FSFtpClientWrapper fw = new FSFtpClientWrapper()) {
            // your rest of the codes here..
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class FSFtpClientWrapper implements AutoCloseable {
        @Override
        public void close() throws Exception {
            // Empty implementation
        }
    }

    public static class Unwrapable implements AutoCloseable {
        public String name;
        @Override
        public void close() throws Exception {
            // Empty implementation
        }
    }
}