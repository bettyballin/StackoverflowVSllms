import java.util.Random;
import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class CelestialJukebox {
    private final Random random;
    private BitSet playedSongs; // Tracks which songs have been played.
    private int totalSongs;     // The current upper bound for song indices (exclusive).
    private Pool pool;          // Active pool of unused songs.

    public CelestialJukebox(int initialSongCount) {
        random = new Random();
        totalSongs = initialSongCount;
        playedSongs = new BitSet(initialSongCount);
        pool = new Pool(new ArrayList<>(), new HashSet<>());
        regeneratePoolIfNecessary(random);
    }

    private class Pool {
        List<Integer> available;
        HashSet<Integer> lookup;

        Pool(List<Integer> available, HashSet<Integer> lookup) {
            this.available = available;
            this.lookup = lookup;
        }
    }

    public int nextSong() {
        if (pool.available.isEmpty()) {
            // Regenerate the pool when we run out of songs.
            regeneratePool(random);
        }
        int songIndex = pickFromPool();
        playedSongs.set(songIndex);
        return songIndex;
    }

    private int pickFromPool() {
        int randomIndex = random.nextInt(pool.available.size());
        int songIndex = pool.available.remove(randomIndex);
        pool.lookup.remove(songIndex);
        return songIndex;
    }

    public void addNewSong(int batchSize) {
        totalSongs += batchSize;
        // Regenerate the pool to include new songs without re-playing old ones.
        regeneratePoolIfNecessary(random);
    }

    private void regeneratePool(Random random) {
        List<Integer> available = new ArrayList<>(totalSongs - playedSongs.cardinality());
        for (int i = 0; i < totalSongs; i++) {
            if (!playedSongs.get(i)) {
                available.add(i);
            }
        }
        Collections.shuffle(available, random);

        // If the pool is empty and there are no new songs, clear played to restart.
        if (available.isEmpty()) {
            playedSongs.clear();
            for (int i = 0; i < totalSongs; i++) {
                available.add(i);
            }
            Collections.shuffle(available, random);
        }

        pool.available.clear();
        pool.lookup.clear();
        pool.available.addAll(available.subList(0, Math.min(500, available.size()))); // Limit initial pool.
        for (int songId : pool.available) {
            pool.lookup.add(songId);
        }
    }

    private void regeneratePoolIfNecessary(Random random) {
        if (pool == null || pool.available.isEmpty()) {
            regeneratePool(random);
        }
    }

    public static void main(String[] args) {
        CelestialJukebox jukebox = new CelestialJukebox(10); // Initial song count.
        for (int i = 0; i < 20; i++) { // Play 20 songs, some of which may be repeats until pool refills.
            System.out.println("Playing song " + jukebox.nextSong());
        }
        jukebox.addNewSong(3); // Add new songs.
    }
}