class ObjectHandle {
    private final Object referent; // The actual object being referred to

    public ObjectHandle(Object referent) {
        this.referent = referent;
    }

    public Object getReferent() { // Returns a reference to this handle's target.
        return referent;
    }

    public boolean isValid() {
        // Determine if the referent is still valid (not null in this simple example)
        return referent != null;
    }

    // ...
}

public class SomeClass {
    private final ObjectHandle handle; // Holds a reference to some other object

    public SomeClass(ObjectHandle handle) {
        this.handle = handle;
    }

    public void doSomething() { // Performs an action based on the value held by the handle.
        if(handle == null || !handle.isValid()){ return; } // If the referenced object ceases to exist or is invalid
        Object someObject = handle.getReferent(); // Get a reference to the actual object
        // Perform actions with someObject
        System.out.println("Doing something with " + someObject.toString());
        // ...
    }

    public static void main(String[] args) {
        Object obj = new Object();
        ObjectHandle handle = new ObjectHandle(obj);
        SomeClass someClass = new SomeClass(handle);
        someClass.doSomething();
    }
}