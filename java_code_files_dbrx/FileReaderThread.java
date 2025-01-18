import java.io.*;

public class FileReaderThread {

    Thread readThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try (FileInputStream fis = new FileInputStream("output.txt")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line;
                while ((line = reader.readLine()) != null) {
                    // Update any UI components or other logic here as we read data line by line
                    yourUiUpdatingFunctionOrAnyLogicHere();
                }
            } catch (IOException ex) {
                // Log the exception details and notify of any error encountered via logging/UI etc.
                logOrInformOfException(ex);
            }
        }
    });

    public static void main(String[] args) {
        FileReaderThread frt = new FileReaderThread();
        frt.readThread.start();
    }

    private void yourUiUpdatingFunctionOrAnyLogicHere() {
        // Placeholder method
    }

    private void logOrInformOfException(Exception ex) {
        // Placeholder method
    }
}