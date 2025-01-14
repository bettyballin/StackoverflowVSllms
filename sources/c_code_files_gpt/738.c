#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int someValue;
    char *buffer;
} BIG_INPUT_STRC;

typedef struct {
    int resultCode;
    char *outputBuffer;
} BIG_OUTPUT_STRC;

int main() {
    // Create an instance of BIG_INPUT_STRC
    BIG_INPUT_STRC input;
    input.someValue = 10;
    input.buffer = malloc(1024);
    strcpy(input.buffer, "Hello, World!");

    // Create an instance of BIG_OUTPUT_STRC
    BIG_OUTPUT_STRC output;
    output.resultCode = 0;
    output.outputBuffer = malloc(1024);
    strcpy(output.outputBuffer, "Output buffer");

    // Print the values
    printf("Input someValue: %d\n", input.someValue);
    printf("Input buffer: %s\n", input.buffer);
    printf("Output resultCode: %d\n", output.resultCode);
    printf("Output outputBuffer: %s\n", output.outputBuffer);

    // Free the allocated memory
    free(input.buffer);
    free(output.outputBuffer);

    return 0;
}