public class ParityCalculator {
    // Function to calculate parity bit for 8-bit data
    public byte calculateParity(byte data) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if ((data & (1 << i)) != 0) {
                count++;
            }
        }
        return (byte)(count % 2);
    }

    // Function to verify parity bit
    public boolean verifyParity(byte data, byte expectedParity) {
        byte calculatedParity = calculateParity(data);
        return calculatedParity == expectedParity;
    }

    public static void main(String[] args) {
    }
}