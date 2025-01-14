public class SineWaveGenerator {
    private long accum = 0;
    private long NCO_param = 1024; // Example increment
    private static final long MAX_MODULO = 1L << 32; // MAX_MODULO = 2^32
    private static final int WAVETABLE_SIZE = 1024; // Example size for the wave table
    private float[] sineLookupTable = new float[WAVETABLE_SIZE];

    public SineWaveGenerator() {
        // Initialize the sine lookup table with sine values
        for (int i = 0; i < WAVETABLE_SIZE; i++) {
            sineLookupTable[i] = (float) Math.sin(2 * Math.PI * i / WAVETABLE_SIZE);
        }
    }

    void clockTick() {
        accum = (accum + NCO_param) % MAX_MODULO; // Use MAX_MODULO = 2^32 for full range of 32-bit integer if necessary
        int phaseIndex = (int)((accum * WAVETABLE_SIZE) >>> 32); // Map the accumulated value to a lookup table index
        float waveformSample = sineLookupTable[phaseIndex]; // Fetch the waveform sample from the lookup table
        // Use waveformSample as needed
    }

    public static void main(String[] args) {
        SineWaveGenerator generator = new SineWaveGenerator();
        generator.clockTick(); // Call clockTick
    }
}