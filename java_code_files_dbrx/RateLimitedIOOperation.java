import java.lang.String;
import java.io.*;
import java.net.Socket;

public class RateLimitedIOOperation {
    // Token bucket variables
    private double tokenBucketSize;
    private double maxBitRate; // Maximum bitrate threshold (bits/sec)

    public RateLimitedIOOperation(double tokensPerSeconds, double maxBitRate){
        this.maxBitRate = maxBitRate * 125L; // Bit rate to packet rate conversion: maxPacketsInBytes / 10 seconds per packet * bits in a byte * packets/sec
        this.tokenBucketSize = tokensPerSeconds;
    }

    public void downloadFromSocket(Socket socket) throws IOException, InterruptedException {
        // IO variables for reading data from the socket
        InputStream inputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bufferByteArray = new byte[1024];

        double tokensLeft = tokenBucketSize;
        long startTime, elapsedTime = 0L;

        while (inputStream != null) { // Read the socket input until there is no more data to read.
            synchronized(this){
                startTime = System.currentTimeMillis(); // Get current time in milliseconds
            }

            int bytesRead = inputStream.read(bufferByteArray);
            if (bytesRead > 0) {
                tokensLeft -= (double)(bytesRead * 8) / maxBitRate; // Consume the respective number of tokens from the bucket based on a packet size.

                while(!isBucketPositive(tokensLeft)) { // If there's not enough token left in the bucket, wait till it gets refilled to certain level (not 0 - because then you won't be able maintain constant download rate).
                    synchronized(this) {
                        elapsedTime = System.currentTimeMillis() - startTime; // Get the elapsed time since last reset.
                        updateBucketSizeByElapsedTime((double)(elapsedTime / 1000L)); // Update bucket token sizes based on passed times (in seconds).
                    }
                }
            } else { // If read() method was invoked but no bytes were available to be read, i.e., end of stream has been reached.
                break;
            }
        }
    }

    /**
     * Check is bucket still have positive token sizes left or not.
     * @param tokensLeft - current size of the bucket in tokens
     * @return true if there are some tokens remains, false otherwise.
     */
    private boolean isBucketPositive(double tokensLeft) {
        return tokensLeft > 0;
    }

    /**
     * Update tokens based on a time that passed since last reset.
     * @param elapsedTimeMS - total time (in seconds) from the previous bucket update
     */
    private void updateBucketSizeByElapsedTime(double elapsedTimeSecond){
        synchronized(this){ // Ensure thread-safety here as method execution might be preempted.
            tokenBucketSize += maxBitRate * elapsedTimeSecond;  // Replenish the bucket with tokens that represent new data (at fixed bitrate).
            if(tokenBucketSize > this.tokenBucketSize) { // If tokens increased more than threshold, keep it at maximum value only.
                tokenBucketSize = this.tokenBucketSize;
            }
        }
    }

	public static void main(String[] args) {
	}
}