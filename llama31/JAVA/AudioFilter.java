import java.lang.String;
public class AudioFilter {
    public static double[] lowPassFilter(double[] audioSamples, double cutoffFrequency) {
        double[] filteredSamples = new double[audioSamples.length];
        double smoothingFactor = 0.5; // adjust this value to tweak the filter

        filteredSamples[0] = audioSamples[0];
        for (int i = 1; i < audioSamples.length; i++) {
            filteredSamples[i] = (1 - smoothingFactor) * audioSamples[i] + 
                                 smoothingFactor * filteredSamples[i - 1];
        }

        return filteredSamples;
    }

    public static double[] highPassFilter(double[] audioSamples, double cutoffFrequency) {
        double[] filteredSamples = new double[audioSamples.length];
        double smoothingFactor = 0.5; // adjust this value to tweak the filter

        filteredSamples[0] = audioSamples[0];
        for (int i = 1; i < audioSamples.length; i++) {
            filteredSamples[i] = (1 + smoothingFactor) * audioSamples[i] - 
                                 smoothingFactor * filteredSamples[i - 1];
        }

        return filteredSamples;
    }

	public static void main(String[] args) {
	}
}