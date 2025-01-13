public class Main_726 {
    public static void main(String[] args) {
        String frame = "MESSAGE\nheader:value\n\nbody\0";
        frame = frame.replace("\0", "\\x00");
        System.out.println(frame);
        // transmit the frame over the socket
    }
}