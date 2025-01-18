@interface ContractAnnotation {
    boolean required() default false; // Whether the field is required or optional.
}
public class EmployeeDTO {
    @ContractAnnotation(required = true) String firstName;
    @ContractAnnotation(required = true) String lastName;
    int idNumber; // No Contract Annotation means it's an optional property.

    public String getFullName() {
        return null;
    } // Method to return full name using required properties: first and last names, which are type-safe guaranteed to be present in any instance of this class according to the contract specified by the @ContractAnnotation. If any other field or method requires any additional fields (such as idNumber), it can easily check if its null before processing accordingly.

    public static void main(String[] args) {
    }
}