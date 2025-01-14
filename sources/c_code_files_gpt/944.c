#include <stdio.h>

#define STRING_LIST(M) \
    M(STR_YES, "yes")  \
    M(STR_NO, "no")    \
    M(STR_MAYBE, "maybe")

// Define the enum using the macro
#define ENUM_ENTRY(name, string) name,
typedef enum {
    STRING_LIST(ENUM_ENTRY)
    STR_COUNT // This will automatically keep track of the number of entries
} StringIndices;
#undef ENUM_ENTRY

// Define the array of strings using the same macro
#define STRING_ENTRY(name, string) string,
const char *strings[] = {
    STRING_LIST(STRING_ENTRY)
};
#undef STRING_ENTRY

int main() {
    // Example usage
    printf("STR_YES: %s\n", strings[STR_YES]);
    printf("STR_NO: %s\n", strings[STR_NO]);
    printf("STR_MAYBE: %s\n", strings[STR_MAYBE]);

    return 0;
}