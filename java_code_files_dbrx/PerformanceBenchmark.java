public class PerformanceBenchmark {
    public static void main(String[] args) {
        long totalExecutionTime_Setup1, totalExecutionTime_Setup2;

        // time content is served in Setup 1 and Setup 2 respectively
        totalExecutionTime_Setup1 = calculateTotalPageLoadTime(1.5) + // assuming 1.5 seconds to fetch all data for server-side rendering
                    calculateJavaScriptParsingTime(); // considering the javascript parsing time here as well since it occurs on first-page load before content is added to DOM

        totalExecutionTime_Setup2 = calculateSkeletonLoadTime() +  // assuming fast skeleton load
                      addContentToDomProgressivelyWithAjaxCalls(); // including multiple network trips for getting data and adding to the DOM progressively with AJAX
    }

    public static long calculateTotalPageLoadTime(double dataFetchTime) {
        // assuming data fetch time in seconds, converting to milliseconds
        return (long)(dataFetchTime * 1000);
    }

    public static long calculateJavaScriptParsingTime() {
        // dummy implementation
        return 500; // milliseconds
    }

    public static long calculateSkeletonLoadTime() {
        // dummy implementation
        return 200; // milliseconds
    }

    public static long addContentToDomProgressivelyWithAjaxCalls() {
        // dummy implementation
        return 1500; // milliseconds
    }
}