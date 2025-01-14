public class Native {
    static {
        System.loadLibrary("native");
    }
    
    public native int setUser(int uid);

    public void runAsUser(int userId) {
       setUser(userId);
    }

    public static void main(String[] args) throws Exception {
        new Native().runAsUser(1015);  // User ID for 'user1'
    }
}