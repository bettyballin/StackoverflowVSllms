#include <stdio.h>
#include <stdlib.h>

// Placeholder functions for add_record and remove_record
void add_record() {
    printf("Adding a record...\n");
}

void remove_record() {
    printf("Removing a record...\n");
}

void handle_packet(const char* buffer) {
    switch (buffer[0]) { // 'A' - Add record;  'R' - Remove record.
        case 'A': add_record(); break;
        case 'R': remove_record(); break;
        default: printf("Invalid operation type.\n"); exit(1); // Exit the execution if an unrecognized command is found in a packet buffer.
    }
}

int main() {
    // Example usage
    const char* buffer1 = "A";
    const char* buffer2 = "R";
    const char* buffer3 = "X"; // Invalid operation

    handle_packet(buffer1);
    handle_packet(buffer2);
    handle_packet(buffer3);

    // To see the output of the first two operations before exit(1) due to the third buffer.
    // Use a command like this in your terminal: gcc -o program your_code_file.c; ./program

    return 0;
}