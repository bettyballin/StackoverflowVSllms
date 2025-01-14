#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char operation; // 'A' for add, 'R' for remove, etc.
    int record_id;  // ID of the database record
    char payload[]; // Data associated with the request (optional)
} Packet;

int main() {
    // Example usage of the Packet struct
    Packet* packet = malloc(sizeof(Packet) + sizeof(char) * 100); // Allocate space for the struct plus a 100-character payload
    if (packet == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    packet->operation = 'A'; // Example operation
    packet->record_id = 1;   // Example record ID
    sprintf(packet->payload, "Example payload"); // Assign a string to the payload

    printf("Operation: %c\n", packet->operation);
    printf("Record ID: %d\n", packet->record_id);
    printf("Payload: %s\n", packet->payload);

    free(packet); // Free the allocated memory

    return 0;
}