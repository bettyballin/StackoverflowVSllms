public class MaxHeap<T extends Comparable<T>> {

    private T[] queue = (T[]) new Comparable[11]; // array indices from 1 to 10
    private int size = 0;

    public void add(T value){
        queue[++size] = value;
        swim(size); // Swimming up to maintain max-heap property
    }

    void swim(int k){
        while (k > 1 && greater(parentIndex(k), k)){
            exchange(k, parentIndex(k));
            k = parentIndex(k);
        }
    }

    private boolean greater(int i, int j) {
        return queue[i].compareTo(queue[j]) > 0;
    }

    private void exchange(int i, int j) {
        T temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    private int parentIndex(int k) {
        return k / 2;
    }

    public static void main(String[] args) {
    }
}