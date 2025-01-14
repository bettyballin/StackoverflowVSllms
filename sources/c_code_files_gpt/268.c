#include <stdio.h>

int my_function(char *p_in_string, char *p_out_string) {
    // Add your function implementation here
    printf("Input string: %s\n", p_in_string);
    printf("Output string: %s\n", p_out_string);
    return 0;
}

int main() {
    char in_string[] = "Hello";
    char out_string[] = "World";
    my_function(in_string, out_string);
    return 0;
}