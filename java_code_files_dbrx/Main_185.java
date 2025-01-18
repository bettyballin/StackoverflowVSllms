public class Main {
    public interface Image {
        void draw();
    }

    public static class RealImage implements Image {
        @Override
        public void draw() {
            System.out.println("Drawing the real image");
        }
    }

    public static void main(String[] args) {
        // Create the real image object
        final RealImage realImage = new RealImage();

        // Create InvocationHandler
        java.lang.reflect.InvocationHandler handler = new java.lang.reflect.InvocationHandler() {
            private final Image image = realImage;

            @Override
            public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
                // Here you can add any extra logic if you want
                System.out.println("Proxy: Invoking method " + method.getName());
                return method.invoke(image, args);
            }
        };

        // Create proxy instance
        Object proxy = java.lang.reflect.Proxy.newProxyInstance(
                Image.class.getClassLoader(),
                new Class[] { Image.class },
                handler
        );

        // The code given:
        Image image = (Image) proxy; // create proxy
        image.draw(); // call method of the original object using the proxy
    }
}