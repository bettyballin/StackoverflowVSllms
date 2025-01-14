// File: com/example/p2p/PeerToPeerLibrary.java
package com.example.p2p;

public class PeerToPeerLibrary {
    public FileSharer createFileSharer(String path) {
        return new FileSharer(path);
    }
}

// File: com/example/p2p/FileSharer.java
package com.example.p2p;

public class FileSharer {
    private String filePath;

    public FileSharer(String path) {
        this.filePath = path;
    }
    
    public void startSharing() {
        // Implement sharing functionality here
        System.out.println("Started sharing file: " + filePath);
    }
}

// File: FileSharingApp.java
import com.example.p2p.PeerToPeerLibrary;
import com.example.p2p.FileSharer;

public class FileSharingApp {
    public static void main(String[] args) {
        // Initialize the P2P system
        PeerToPeerLibrary p2pSystem = new PeerToPeerLibrary();
        
        // Create a file sharer instance
        FileSharer fileSharer = p2pSystem.createFileSharer("path/to/file.txt");
        
        // Start sharing
        fileSharer.startSharing();
    }
}