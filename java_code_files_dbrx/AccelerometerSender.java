import java.io.*;
import java.net.Socket;

public class AccelerometerSender {

    public static void main(String[] args) throws IOException {
        // Declare variables
        double xValue = 0.0; // Replace with your actual values
        double yValue = 0.0;
        double zValue = 0.0;

        // Create socket connection
        Socket socket = new Socket("localhost", 12345); // Replace 12345 with your port

        // Create a new acceleration measurement event object
        AccelerometerData data = AccelerometerData.newBuilder()
                .setMeasurementTime(System.currentTimeMillis())
                .setXAxis(xValue) // Replace with your actual values for x, y and z axis accelerations
                .setYAxis(yValue)
                .setZAxis(zValue)
                .build();

        // Convert the data object to bytes and send it over TCP connection.
        byte[] byteData = data.toByteArray();
        socket.getOutputStream().write(byteData); // Send the data through TCP connection.

        socket.close(); // Close the socket
    }
}

// Define the AccelerometerData class
class AccelerometerData {

    private long measurementTime;
    private double xAxis;
    private double yAxis;
    private double zAxis;

    private AccelerometerData(Builder builder) {
        this.measurementTime = builder.measurementTime;
        this.xAxis = builder.xAxis;
        this.yAxis = builder.yAxis;
        this.zAxis = builder.zAxis;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] toByteArray() {
        // For simplicity, serialize the fields into bytes
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            DataOutputStream dos = new DataOutputStream(buffer);
            dos.writeLong(measurementTime);
            dos.writeDouble(xAxis);
            dos.writeDouble(yAxis);
            dos.writeDouble(zAxis);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    public static class Builder {
        private long measurementTime;
        private double xAxis;
        private double yAxis;
        private double zAxis;

        public Builder setMeasurementTime(long measurementTime) {
            this.measurementTime = measurementTime;
            return this;
        }

        public Builder setXAxis(double xAxis) {
            this.xAxis = xAxis;
            return this;
        }

        public Builder setYAxis(double yAxis) {
            this.yAxis = yAxis;
            return this;
        }

        public Builder setZAxis(double zAxis) {
            this.zAxis = zAxis;
            return this;
        }

        public AccelerometerData build() {
            return new AccelerometerData(this);
        }
    }
}