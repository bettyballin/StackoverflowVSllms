#include <stdlib.h>
#include <stdio.h>

// Define a struct to mimic DLL functionality
typedef struct {
    void (*do)(void);
    void (*cleanup)(void);
} DLL;

// Global pointer to hold allocated memory
char *a = NULL;

void do_func() {
    a = (char *)malloc(1024);
    printf("Memory allocated\n");
}

// Function to free the allocated memory
void cleanup_func() {
    if (a != NULL) {
        free(a);
        a = NULL;
        printf("Memory cleaned up\n");
    }
}

// Function to load the DLL
DLL* LoadDLL() {
    DLL* dll = (DLL*)malloc(sizeof(DLL));
    dll->do = do_func;
    dll->cleanup = cleanup_func;
    return dll;
}

// Function to unload the DLL
void UnloadDLL(DLL* dll) {
    free(dll);
    printf("DLL unloaded\n");
}

// Main function or the point where DLL is used
int main() {
    DLL* dll = LoadDLL();
    dll->do();
    
    // Perform operations...
    printf("Performing operations...\n");

    // Cleanup before unloading the DLL
    dll->cleanup();
    UnloadDLL(dll);
    
    return 0;
}