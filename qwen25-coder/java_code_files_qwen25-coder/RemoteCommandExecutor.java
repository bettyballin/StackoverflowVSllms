import com.jcraft.jsch.*;

import java.io.InputStream;
import java.io.OutputStream;

public class RemoteCommandExecutor {
    public static void main(String[] args) {
        String host = "your_server_ip";
        String user = "your_username";
        String password = "your_password";
        String command = "dir"; // Example command to list directory contents

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);

            // Avoid asking for key confirmation
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);

            // Set input and output streams
            OutputStream out = channelExec.getOutputStream();
            InputStream in = channelExec.getInputStream();

            channelExec.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if(i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channelExec.isClosed()){
                    System.out.println("Exit Status: " + channelExec.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }

            channelExec.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}