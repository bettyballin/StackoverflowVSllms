import java.lang.String;
import java.util.Iterator;

public class BeanPointerIterator {

    AnimsContext animsContext = new AnimsContext();
    Iterator<BeanPointer> iter = animsContext.iteratePointers("//Animal[getType()='CA']");

    public static void main(String[] args) {
    }
}

class BeanPointer {
    // Empty class representing a BeanPointer
}

class AnimsContext {
    public Iterator<BeanPointer> iteratePointers(String s) {
        return new Iterator<BeanPointer>() {
            public boolean hasNext() {
                return false;
            }
            public BeanPointer next() {
                return null;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}