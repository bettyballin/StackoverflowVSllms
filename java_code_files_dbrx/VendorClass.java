// File: VendorClass.java
public class VendorClass {
    // existing code goes here...
}

// File: ExtendedVendorClass.java
public class ExtendedVendorClass extends VendorClass {
    private String newProperty; // added property

    public String getNewProperty() {
        return newProperty;
    }
    // other methods, fields etc. can go in this extended version of the service contract if needed.
}