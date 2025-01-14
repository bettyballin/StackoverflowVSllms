import java.util.concurrent.LinkedBlockingQueue;
import java.nio.channels.SelectableChannel;

public class MainClass {
    public static void main(String[] args) {
        LinkedBlockingQueue<Triple<SelectableChannel, ComponentSocketBasis, Integer>> deferredPollQueue = new LinkedBlockingQueue<>();

        SelectableChannel channel = null;
        ComponentSocketBasis sock = null;
        Integer ops = 0;

        deferredPollQueue.offer(Triple.of(channel, sock, ops));
    }

    // Define Triple class
    public static class Triple<L, M, R> {
        private final L left;
        private final M middle;
        private final R right;

        public Triple(L left, M middle, R right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
            return new Triple<>(left, middle, right);
        }

        public L getLeft() {
            return left;
        }

        public M getMiddle() {
            return middle;
        }

        public R getRight() {
            return right;
        }
    }

    public static class ComponentSocketBasis {
        // Empty class for compilation
    }
}