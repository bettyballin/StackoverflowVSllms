#include <stdbool.h>\n\n#define TILETYPE_CONDUCTIVE 0x01\n\ntypedef struct {\n    unsigned long mapDimensions[2];\n    unsigned short *map;\n    tilemapData **tiles;\n    poweredObject **poweredObjects;\n    int numChunks[1];\n} Level;\n\ntypedef struct {\n    unsigned long position[2];\n    powerNetInfo *powerNet;\n} poweredObject;\n\ntypedef struct {\n    unsigned int flags;\n} tilemapData;\n\ntypedef struct {\n    unsigned long objectsInNet;\n} powerNetInfo;\n\nLevel *level;\n\nvoid findSetPoweredObjects(unsigned long x, unsigned long y, powerNetInfo *powerNet) {\n    // Look for poweredObjs on this tile and set their powerNet to the given powernet\n    for (int i = 0; i < level->numChunks[0]; i++) {\n        if (level->poweredObjects[i]->position[0] == x && level->poweredObjects[i]->position[1] == y) {\n            level->poweredObjects[i]->powerNet = powerNet;\n            powerNet->objectsInNet++;\n        }\n    }\n}\n\nvoid recursiveCheckTile(bool *isWalked, powerNetInfo *powerNet, long x, long y, tilemapData *levelMap) {\n    // If out of bounds, return\n    if (x < 0 || y < 0 || x >= level->mapDimensions[0] || y >= level->mapDimensions[1]) return;\n    // If tile already walked, return\n    if (isWalked[x + (y * level->mapDimensions[0])]) return;\n    // If tile is nonconductive, return\n    if (!(level->tiles[levelMap->map[x + (y * level->mapDimensions[0])]]->flags & TILETYPE_CONDUCTIVE)) return;\n\n    // Valid tile to check, see if there's a poweredobj on the tile (link it to the net if it is) and check the adjacent tiles.\n    isWalked[x + (y * level->mapDimensions[0])] = true;\n\n    findSetPoweredObjects(x, y, powerNet);\n\n    // Recursively check adjacent tiles\n    recursiveCheckTile(isWalked, powerNet, x - 1, y, levelMap);\n    recursiveCheckTile(isWalked, powerNet, x + 1, y, levelMap);\n    recursiveCheckTile(isWalked, powerNet, x, y - 1, levelMap);\n    recursiveCheckTile(isWalked, powerNet, x, y + 1, levelMap);\n}\n\nbool buildPowerNets(void) {\n    unsigned long mapSize = level->mapDimensions[0] * level->mapDimensions[1];\n    bool *isWalked = (bool *)calloc(mapSize, sizeof(bool));\n    if (!isWalked) return false; // Handle memory allocation failure\n\n    // Example of initialization and usage\n    powerNetInfo powerNet = {0};\n\n    // Assuming (0, 0) is the starting point; adjust as necessary\n    recursiveCheckTile(isWalked, &powerNet, 0, 0, level->tiles);\n\n    free(isWalked); // Clean up memory allocation\n    return true;\n}