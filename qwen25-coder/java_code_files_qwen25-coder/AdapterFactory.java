public class MainClass {
    interface Adapter<E> {}

    class AdapterFactory<E, A extends Adapter<E>> {
        public AdapterFactory(Class<E> extl, Class<A> intl) {}
    }

    class Adaptulator<I> {
        private Class<I> iClass;

        public Adaptulator(Class<I> iClass) {
            this.iClass = iClass;
        }

        <E, A extends Adapter<E>> void addWithClassBound(Class<E> extl, Class<A> intl) {
            // Ensure that 'A' is also a subclass of 'I'
            if (intl == null || !((Class<?>) iClass).isAssignableFrom((Class<?>) intl)) {
                throw new IllegalArgumentException("Provided class does not extend I");
            }
            addAdapterFactory(new AdapterFactory<>(extl, intl));
        }

        <E, A extends Adapter<E>> void add(Class<E> extl, Class<A> intl) {
            if (!((Class<?>) Adapter.class).isAssignableFrom((Class<?>) intl)) {
                throw new IllegalArgumentException("Provided class must implement Adapter");
            }
            addWithClassBound(extl, intl);
        }

        private <E, A extends Adapter<E>> void addAdapterFactory(AdapterFactory<E, A> factory) {
            // Implementation here
        }
    }

    public static void main(String[] args) {
    }
}