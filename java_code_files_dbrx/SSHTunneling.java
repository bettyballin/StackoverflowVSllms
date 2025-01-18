import com.jcraft.jsch.*;
import java.util.Properties;

class SSHTunneling {
    public static void main(String[] args) throws Exception {
        String user = "username";
        String password = "password";
        // Change it to your SSH server IP or hostname:
        String host = "remote_ssh_server";
        int port = 22;
        Properties props = new Properties();
        Session session = new JSch().getSession(user, host, port);
        props.put("StrictHostKeyChecking", "no");
        session.setConfig(props);
        session.setPassword(password);
        session.connect();
        System.out.println("Connected successfully to " + host + ".");
    }
}