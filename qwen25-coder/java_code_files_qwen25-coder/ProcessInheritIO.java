import java.lang.String;
import java.io.*;

public class ProcessInheritIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] command = {"your_command", "arg1", "arg2"}; // Replace with your command

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        // Pipe the subprocess's stdout and stderr to System.out
        Thread stdoutThread = new StreamGobbler(process.getInputStream(), System.out);
        Thread stderrThread = new StreamGobbler(process.getErrorStream(), System.err);

        // Pipe the user's input (System.in) to subprocess's stdin
        OutputStream os = process.getOutputStream();
        Thread stdinThread = new StreamCopier(System.in, os);

        stdoutThread.start();
        stderrThread.start();
        stdinThread.start();

        // Wait for the subprocess to exit
        int exitCode = process.waitFor();

        // Clean up
        stdoutThread.join();
        stderrThread.join();
        stdinThread.join();
        System.exit(exitCode);
    }

    static class StreamGobbler extends Thread {
        private InputStream is;
        private PrintStream ps;

        StreamGobbler(InputStream is, PrintStream ps) {
            this.is = is;
            this.ps = ps;
        }

        @Override
        public void run() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    ps.println(line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try { if (br != null) br.close(); } catch (IOException e) { /* ignored */ }
            }
        }
    }

    static class StreamCopier extends Thread {
        private InputStream is;
        private OutputStream os;

        StreamCopier(InputStream is, OutputStream os) {
            this.is = is;
            this.os = os;
        }

        @Override
        public void run() {
            BufferedReader br = null;
            BufferedWriter bw = null;
            try {
                br = new BufferedReader(new InputStreamReader(is));
                bw = new BufferedWriter(new OutputStreamWriter(os));
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try { if (br != null) br.close(); } catch (IOException e) { /* ignored */ }
                try { if (bw != null) bw.close(); os.close(); } catch (IOException e) { /* ignored */ }
            }
        }
    }
}