import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;

public class SFTPFileCopy {
    public static void main(String[] args) {
        String localFilePath = "/path/to/local/file";
        String remoteFilePath = "/path/to/remote/file";
        String host = "remote-host-address";
        int port = 22;
        String user = "username";
        String password = "password";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(password);
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            InputStream inputStream = new FileInputStream(localFilePath);
            channelSftp.put(inputStream, remoteFilePath);

            inputStream.close();
            channelSftp.disconnect();
            session.disconnect();

            System.out.println("File is successfully copied.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}