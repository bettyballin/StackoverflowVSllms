public class ServletWriterExample {
    static Response response = new Response();
    {
        response.getWriter().write("Some text to test this...");
    }
    public static void main(String[] args) {
    }
}

class Response {
    public Writer getWriter() {
        return new Writer();
    }
}

class Writer {
    public void write(String s) {
        System.out.println(s);
    }
}