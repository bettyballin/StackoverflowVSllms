#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the Packet struct
typedef struct {
    char operation;
    int record_id;
    char* payload;
} Packet;

// Function to deserialize a packet from a string
Packet* deserialize_packet(const char *data) {
    size_t len = strlen(data);
    Packet *result = (Packet*) calloc(1, sizeof(Packet)); // Allocate memory for the packet with null initial values.
    result->operation = data[0];                           // Retrieve first byte as operation type.
    sscanf(data + 1, "%d", &(result->record_id));         // Parse next bytes into a record ID integer.

    size_t payload_length = len - sizeof(char) - sizeof(int);
    result->payload = (char*) calloc((size_t)payload_length + 1, sizeof(char)); // Allocate and null-terminate space for the remaining data as a payload.

    memcpy(result->payload, data + sizeof(char) + sizeof(int), payload_length); // Copy over the rest of the buffer into the Packet object's payload array.

    return result;
}

int main() {
    // Test the deserialize_packet function
    const char* data = "A123Hello, World!";
    Packet* packet = deserialize_packet(data);

    printf("Operation: %c\n", packet->operation);
    printf("Record ID: %d\n", packet->record_id);
    printf("Payload: %s\n", packet->payload);

    // Free the allocated memory
    free(packet->payload);
    free(packet);

    return 0;
}