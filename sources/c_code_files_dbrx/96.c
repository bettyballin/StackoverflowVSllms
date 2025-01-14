#include <stdio.h>
#include <string.h>
void do_something(char *user_input) {
    char buffer[5]; // Buffer capable of holding only 4 characters + null termination
    strcpy(buffer, user_input); // No bounds checking
}
int main() {
    char input[20] = "example";
    do_something(input);
    return 0;
}