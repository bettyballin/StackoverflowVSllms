#include <stdio.h>

// Define the Header structure (assuming it's not defined elsewhere)
typedef struct {
    // Add the necessary fields for the Header structure
    int field1;
    char field2;
} Header;

// Define the Message structure
typedef struct Message {
    Header header;
    char payload[];  // Flexible array member
} Message;

// Function to get the payload from a Message
char* GetPayload(Message* message) {
    return message->payload;
}

int main() {
    // Example usage:
    Message* msg = malloc(sizeof(Message) + 10); // Allocate space for the message and a 10-byte payload
    strcpy(msg->payload, "Hello"); // Copy a string into the payload
    printf("%s\n", GetPayload(msg)); // Print the payload
    free(msg); // Free the allocated memory
    return 0;
}