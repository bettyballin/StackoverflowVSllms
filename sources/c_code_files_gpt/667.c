#include <stdio.h>
#include <uuid/uuid.h>

int main() {
    uuid_t bin_uuid;
    uuid_generate_random(bin_uuid);

    char uuid[37];
    uuid_unparse(bin_uuid, uuid);

    printf("Generated UUID: %s\n", uuid);

    return 0;
}