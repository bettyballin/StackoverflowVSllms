public class WebServiceProcessor {
    private static final Logger logger = Logger.getLogger(WebServiceProcessor.class);

    public void processRequest() {
        long startTime = System.currentTimeMillis();
        
        // Process SOAP message and do some initial processing
        long afterInitialProcessingTime = System.currentTimeMillis();

        // Call external web service
        callExternalWebService();
        long afterWsCallTime = System.currentTimeMillis();

        // Massage the received data before responding back
        massageData();
        long endTime = System.currentTimeMillis();

        // Calculate durations
        long totalDuration = (endTime - startTime);
        long initialProcessingTime = (afterInitialProcessingTime - startTime);
        long wsCallDuration = (afterWsCallTime - afterInitialProcessingTime);
        long dataMassageDuration = (endTime - afterWsCallTime);

        // Log the results in a single line
        logger.info("Request processing times: total={}ms, initial-processing={}ms, ws-call={}ms, data-massage={}ms",
                totalDuration, initialProcessingTime, wsCallDuration, dataMassageDuration);
    }

    private void callExternalWebService() {
        // Simulate external web service call delay
        try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private void massageData() {
        // Simulate data processing delay
        try { Thread.sleep(861); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static void main(String[] args) {
        new WebServiceProcessor().processRequest();
    }
}

// Minimal Logger class to support compilation
class Logger {
    public static Logger getLogger(Class<?> cls) {
        return new Logger();
    }

    public void info(String format, Object... args) {
        String message = String.format(format.replace("{}", "%s"), args);
        System.out.println(message);
    }
}