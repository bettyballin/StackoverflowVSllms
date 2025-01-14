#include <stdint.h>
#include <arpa/inet.h>

typedef struct {
    uint32_t  time_low;
    uint16_t  time_mid;
    uint16_t  time_hi_and_version;
    uint8_t   clock_seq_hi_and_reserved;
    uint8_t   clock_seq_low;
    uint8_t   node[6];
} uuid_t;

void hton_uuid(uuid_t *uuid) {
    uuid->time_low = htonl(uuid->time_low);
    uuid->time_mid = htons(uuid->time_mid);
    uuid->time_hi_and_version = htons(uuid->time_hi_and_version);
    // No need to swap clock_seq_hi_and_reserved, clock_seq_low, and node
}

void ntoh_uuid(uuid_t *uuid) {
    uuid->time_low = ntohl(uuid->time_low);
    uuid->time_mid = ntohs(uuid->time_mid);
    uuid->time_hi_and_version = ntohs(uuid->time_hi_and_version);
    // No need to swap clock_seq_hi_and_reserved, clock_seq_low, and node
}

int main() {
    uuid_t uuid;
    // Initialize uuid here if needed
    hton_uuid(&uuid);
    ntoh_uuid(&uuid);
    return 0;
}