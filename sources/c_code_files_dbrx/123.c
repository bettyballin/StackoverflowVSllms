// apiheader-override.c
#include <stdio.h>

// Define the object struct (assuming it's not defined elsewhere)
typedef struct object {
    // Add object properties here if needed
} object;

char const * getObjectName(object *anObject) {
   // Log the call or manipulate data here.
   printf("Function was called.\n");
    if (anObject == NULL) {
      return "(null)";
  } else {
      return "name should be here";
   }
}

int main() {
    // Create an instance of the object (if needed)
    object *myObject = NULL;

    // Test the function
    printf("%s\n", getObjectName(myObject));

    return 0;
}