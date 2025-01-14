#include <string.h>
#include <stdio.h>

#define SUCCESS 0
#define FAILURE 1

int my_function(char *p_in_string, char *p_out_string) {
    if (p_in_string == NULL || p_out_string == NULL) {
        return FAILURE;
    }
    // Example operation: copying the input string to the output string
    strcpy(p_out_string, p_in_string);
    return SUCCESS;
}

int main() {
    char input[] = "Hello, World!";
    char output[50];
    int status = my_function(input, output);
    if (status == SUCCESS) {
        printf("Output: %s\n", output);
    } else {
        printf("Function failed.\n");
    }
    return 0;
}