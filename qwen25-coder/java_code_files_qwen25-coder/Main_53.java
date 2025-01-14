public class Main {
    public static void main(String[] args) {
        int pageSize = (int)Math.round(Math.pow(2, 12)); // 4K page size
        int totalPhysicalMemory = (int)Math.round(Math.pow(2, 17)); // 128KB RAM
        int numberOfPageFrames = totalPhysicalMemory / pageSize; 

        System.out.println("Number of Page Frames: " + numberOfPageFrames); // Outputs 32
    }
}