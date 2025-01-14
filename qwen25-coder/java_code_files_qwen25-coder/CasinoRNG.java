import java.security.SecureRandom;

public class CasinoRNG {
    private SecureRandom secureRandom;

    public CasinoRNG() {
        // Use the default instance which sources entropy from multiple system properties and may use native PRNGs.
        this.secureRandom = new SecureRandom();
        // Optionally, you can reseed it with additional entropy
        byte[] seed = new byte[] {};
        secureRandom.setSeed(seed);
    }

    public int getNextInt(int bound) {
        return secureRandom.nextInt(bound);
    }
}