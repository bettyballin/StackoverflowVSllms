public class MyServiceConsumer {
    @Reference private MyService myService; // this will be automatically injected by the OSGi service framework when an instance is available

    public static void main(String[] args) {
    }
}

@interface Reference {
}

interface MyService {
    // methods (if any)
}