import java.nio.channels.SelectableChannel;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        LinkedBlockingQueue<Tuple3<SelectableChannel, ComponentSocketBasis, Integer>> deferredPollQueue = new LinkedBlockingQueue<>();

        SelectableChannel channel = null;
        ComponentSocketBasis sock = null;
        Integer ops = 0;

        deferredPollQueue.offer(Tuple.of(channel, sock, ops));
    }
}

class ComponentSocketBasis {
    // Empty class for compilation
}

class Tuple {
    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 first, T2 second, T3 third) {
        return new Tuple3<>(first, second, third);
    }
}

class Tuple3<T1, T2, T3> {
    public final T1 _1;
    public final T2 _2;
    public final T3 _3;

    public Tuple3(T1 first, T2 second, T3 third) {
        this._1 = first;
        this._2 = second;
        this._3 = third;
    }
}