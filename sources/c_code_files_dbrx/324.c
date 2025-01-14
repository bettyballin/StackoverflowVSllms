#include <stdio.h>
#include <oci.h>

int main() {
    // Initialize handle area ...
    void *handle = NULL;

    // Call to load Oracle library, function is platform-specific ..
    if (OCIInitialize((OCIEnv **)NULL, OCI_DEFAULT, 0, NULL) == OCI_ERROR) {
        printf("OCIInitialize failed\n");
        return 1; // Return with an error code
    }

    // You should also check the error code for other OCI functions
    // Continue with your code using handle ...

    // Clean up
    OCITerminate(OCI_DEFAULT);

    return 0;
}