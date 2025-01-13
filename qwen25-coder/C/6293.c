#include <stdint.h>\n#include <stdbool.h>\n\n#define TABLE_SIZE 1024 // Should be a power of 2 for optimal modulo operations\n\ntypedef struct {\n    int32_t key;\n    bool occupied;\n} HashEntry;\n\ntypedef struct {\n    HashEntry entries[TABLE_SIZE];\n} HashMap;\n\nvoid initHashMap(HashMap* map) {\n    for (int i = 0; i < TABLE_SIZE; i++) {\n        map->entries[i].occupied = false;\n    }\n}\n\nbool insertUnique(HashMap* map, int num_uniques, int* uniques, int element) {\n    // Simple hash function: modulo operation\n    size_t index = element & (TABLE_SIZE - 1);\n\n    // Linear probing to resolve collisions\n    while (map->entries[index].occupied && map->entries[index].key != element) {\n        index = (index + 1) & (TABLE_SIZE - 1);\n    }\n\n    if (!map->entries[index].occupied) {\n        // Insert new unique element\n        map->entries[index].key = element;\n        map->entries[index].occupied = true;\n\n        // Also store in uniques array\n        uniques[num_uniques] = element;\n        return true;\n    }\n    \n    // Element already present\n    return false;\n}\n\nint extractUnique(int* array, int array_length, int N, int startpos) {\n    HashMap map;\n    initHashMap(&map);\n\n    int num_uniques = 0;\n    while (num_uniques < N && startpos < array_length) {\n        int element = array[startpos++];\n        if (insertUnique(&map, num_uniques, uniques, element)) {\n            num_uniques++;\n        }\n    }\n\n    return num_uniques;\n}\n\nint main() {\n    // Example usage\n    int array[1000]; // Your large list of integers goes here\n    int uniques[20];\n    \n    int found = extractUnique(array, 1000, 10, 0);\n\n    // Use the 'found' number of unique elements in 'uniques'\n\n    return 0;\n}