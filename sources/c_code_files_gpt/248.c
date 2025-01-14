#include <stdio.h>
#include <string.h>

void print_with_dots(const char *tag, const char *data, int total_length) {
    int tag_length = strlen(tag);
    int data_length = strlen(data);
    int num_dots = total_length - tag_length - data_length - 2; // subtract 2 for the brackets

    printf("%s", tag);
    for (int i = 0; i < num_dots; i++) {
        printf(".");
    }
    printf("[%s]\n", data); // added newline character
}

int main() {
    print_with_dots("Number of cards", "500", 50);
    print_with_dots("Fixed prize amount [in whole dollars]", "10", 50);
    print_with_dots("Is this a high winner prize?", "yes", 50);

    return 0;
}