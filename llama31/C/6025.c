typedef struct {\n    uint16_t length;  // Length of the payload\n    uint8_t type;     // Type of packet (e.g., login, query, etc.)\n    char payload[];   // Variable-length payload\n} packet_t;