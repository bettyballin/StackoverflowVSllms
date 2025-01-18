import java.util.Iterator;

public class None_51 {

    static class BeanPointer {}

    static class AnimsContext {
        public Iterator<BeanPointer> iteratePointers(String expression) {
            return null; // Dummy implementation
        }
    }

    AnimsContext animsContext = new AnimsContext();

    Iterator<BeanPointer> legIter = animsContext.iteratePointers("//Animal[getNumLegs()=4]");

    public static void main(String[] args) {
    }
}