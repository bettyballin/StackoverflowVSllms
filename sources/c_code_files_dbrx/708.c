#include <uuid/uuid.h>
#include <stdio.h>

int main() {
    // Generate a GUID / UUID (Universally Unique Identifier) into the provided buffer.
    uuid_t guid;
    uuid_generate(guid);

    // Convert the UUID to a string for printing
    char guid_str[37];
    uuid_unparse(guid, guid_str);

    printf("Generated UUID: %s\n", guid_str);

    return 0;
}