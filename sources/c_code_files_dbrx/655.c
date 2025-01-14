#include <stdio.h>
#include <arpa/inet.h>
#include <stdint.h>

// Assuming uuid_t is not available through an include
typedef struct {
    uint32_t time_low;
    uint16_t time_mid;
    uint16_t time_hi_and_version;
    uint8_t clock_seq_hi_and_reserved;
    uint8_t clock_seq_low;
    uint8_t node[6];
} uuid_t;

void byte_swap_back(uuid_t* uuid) {
    uuid->time_low = ntohl(uuid->time_low);
    uuid->time_mid = ntohs(uuid->time_mid);
    uuid->time_hi_and_version = ntohs(uuid->time_hi_and_version);
}

int main() {
    // Example usage
    uuid_t example_uuid = {
        .time_low = 0x12345678,
        .time_mid = 0x90ab,
        .time_hi_and_version = 0x0cde,
        .clock_seq_hi_and_reserved = 0xef,
        .clock_seq_low = 0x01,
        .node = {0x23, 0x45, 0x67, 0x89, 0xab, 0xcd}
    };

    printf("Before byte swap:\n");
    printf("time_low: 0x%x\n", example_uuid.time_low);
    printf("time_mid: 0x%x\n", example_uuid.time_mid);
    printf("time_hi_and_version: 0x%x\n", example_uuid.time_hi_and_version);

    byte_swap_back(&example_uuid);

    printf("After byte swap:\n");
    printf("time_low: 0x%x\n", example_uuid.time_low);
    printf("time_mid: 0x%x\n", example_uuid.time_mid);
    printf("time_hi_and_version: 0x%x\n", example_uuid.time_hi_and_version);

    return 0;
}