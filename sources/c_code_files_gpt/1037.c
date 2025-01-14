#include <stdio.h>
#include <stdlib.h>

// Simulated definition of object for demonstration
typedef struct object {
    char *name;
} object;

// Simulated original getObjectName function for demonstration
const char *original_getObjectName(object *anObject) {
    if (anObject == NULL)
        return "(null)";
    return anObject->name;
}

// Customized getObjectName function
const char *getObjectName(object *anObject) {
    if (anObject == NULL)
        return "(null)";
    
    // Call the original function
    const char *original_name = original_getObjectName(anObject);
    printf("Original name: %s\n", original_name);

    return original_name;
}

int main() {
    // Create an object
    object myObject;
    myObject.name = "My Object";

    // Call the customized getObjectName function
    const char *name = getObjectName(&myObject);
    printf("Name: %s\n", name);

    // Test with NULL
    name = getObjectName(NULL);
    printf("Name: %s\n", name);

    return 0;
}