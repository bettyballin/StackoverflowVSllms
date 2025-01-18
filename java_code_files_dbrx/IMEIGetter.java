import java.io.*;

public class IMEIGetter {
    private String getIMEINumber() {
        String imei = null;
        String ATcommand = "AT+CGSN"; // Get IMEI command
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        DataOutputStream output = null;

        try {
            process = runtime.exec(new String[]{"/usr/bin/at", "+CMEE=2"}); // Enable verbose error messages

            os = process.getOutputStream();
            is = process.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            output = new DataOutputStream(os);

            try {
                Thread.sleep(1000); // Allow time for the "+CMEE: 2" response if supported.
            } catch (InterruptedException e) {}

            os.write((ATcommand + "\r\n").getBytes());
            output.flush();

            String line = null;
            while ((line = br.readLine()) != null){
                if(line.startsWith("+CGSN:")){
                    imei = line.substring(7); // IMEI is after the ':'
                    break;
                }
            }
        } catch (IOException e) {}
        return imei;
    }
    public static void main(String[] args) {
    }
}