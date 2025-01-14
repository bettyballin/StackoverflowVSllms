import com.jcraft.jsch.*;

public class SshCommandExecutor_1 {
    public static void main(String[] args) {
        String host = "localhost"; // or the actual IP if not local
        int port = 22;
        String user = "jim";
        String password = "<jim's-password>";
        String commandToExecute = "ls ~bob";

        JSch jsch = new JSch();
        Session session = null;

        try {
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(commandToExecute);

            // Get the input stream and output stream for reading and sending data
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            java.io.InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try { Thread.sleep(1000); } catch (Exception ee) {}
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
}