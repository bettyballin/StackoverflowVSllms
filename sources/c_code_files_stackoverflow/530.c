#include <stdio.h>

typedef struct data_buffer {
    char flags;
    char data[128]; // corrected syntax
} data_buffer;

int main() {
    data_buffer db;
    db.flags = 'A';
    db.data[0] = 'H';
    db.data[1] = 'e';
    db.data[2] = 'l';
    db.data[3] = 'l';
    db.data[4] = 'o';
    db.data[5] = '\0'; // null-terminate the string

    printf("Flags: %c\n", db.flags);
    printf("Data: %s\n", db.data);

    return 0;
}