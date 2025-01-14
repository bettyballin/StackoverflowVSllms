import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class SyncManager {
    private Map<String, String> localHashes; // Local storage of hashes
    private Map<String, String> remoteHashes; // Remote storage of hashes

    public SyncManager() {
        localHashes = new HashMap<>();
        remoteHashes = new HashMap<>();
    }

    public void fetchRemoteData(Map<String, byte[]> remoteRecords) throws NoSuchAlgorithmException {
        clearRemoteHashes();
        for (Map.Entry<String, byte[]> entry : remoteRecords.entrySet()) {
            String key = entry.getKey();
            String hash = computeHash(entry.getValue());
            remoteHashes.put(key, hash);
        }
    }

    private void clearRemoteHashes() {
        remoteHashes.clear();
    }

    public Map<String, byte[]> synchronizeData(Map<String, byte[]> remoteRecords) throws NoSuchAlgorithmException {
        Map<String, byte[]> updatesNeeded = new HashMap<>();

        fetchRemoteData(remoteRecords);

        // Check which records are out of sync
        for (Map.Entry<String, String> entry : remoteHashes.entrySet()) {
            String key = entry.getKey();
            String remoteHash = entry.getValue();

            if (!remoteHash.equals(localHashes.getOrDefault(key, ""))) {
                updatesNeeded.put(key, remoteRecords.get(key));
                // Optionally update local hash here
                localHashes.put(key, remoteHash);
            }
        }

        return updatesNeeded;
    }

    private String computeHash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(data);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Additional methods to initialize local hashes, save them after sync, etc.

    public static void main(String[] args) {
    }
}