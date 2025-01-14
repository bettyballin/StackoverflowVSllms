#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to create a copy of the input string
// Note: This function allocates new memory for the string, which the caller is responsible for freeing.
char* safe_string_copy(const char *input) {
    // Calculate the length of the input string plus one for the null terminator
    size_t length = strlen(input) + 1;
    
    // Dynamically allocate memory for the string copy
    char *output = malloc(length * sizeof(char));
    
    // Check if the memory allocation was successful
    if (output == NULL) {
        printf("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    
    // Copy the input string into the allocated memory
    strcpy(output, input);
    
    return output;
}

int main() {
    const char *inputStr = "Hello, World!";
    char *outputStr = safe_string_copy(inputStr);
    
    printf("Copied string: %s\n", outputStr);
    
    // Don't forget to free the allocated memory when you're done with it
    free(outputStr);
    
    return 0;
}