import java.lang.String;
public class SynchronizedUpdater {
    private OtherObject obj;
    // When setObj is called, the lock ensures no concurrent modification issues.
    public void setObj(OtherObject theObj) {
        synchronized (this) {
            obj = theObj;
        }
        // This point marks when local synchronization ends.
        // Now Terracotta replicates this object state.
    }
    
    // Other server nodes will receive the updated 'obj' value eventually.
    public static void main(String[] args) {
    }
}

class OtherObject {
    // Empty class definition to enable compilation
}