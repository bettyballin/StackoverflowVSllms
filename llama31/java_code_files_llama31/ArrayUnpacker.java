/*
 * Decompiled with CFR 0.152.
 */
import java.util.function.Consumer;

public class ArrayUnpacker {
    public static void unpack(double[] dArray, Consumer<Double> ... consumerArray) {
        for (int i = 0; i < consumerArray.length; ++i) {
            consumerArray[i].accept(dArray[i]);
        }
    }

    public static void main(String[] stringArray) {
    }
}
