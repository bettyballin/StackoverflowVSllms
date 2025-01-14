public class MessageHandler {
    public void handleMessage(Object msg) {
        if (msg instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) msg;
            System.out.println("Text: " + textMessage.getContent());
        } else if (msg instanceof ImageMessage) {
            ImageMessage imageMessage = (ImageMessage) msg;
            System.out.println("[" + imageMessage.getUrl() + "] : " + imageMessage.getCaption());
        }
    }

    public static void main(String[] args) {
        // Empty main method
    }
}

class TextMessage {
    public String getContent() {
        return "This is a sample text message.";
    }
}

class ImageMessage {
    public String getUrl() {
        return "http://example.com/image.jpg";
    }

    public String getCaption() {
        return "This is a sample image caption.";
    }
}