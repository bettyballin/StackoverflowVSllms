#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#define TILETYPE_CONDUCTIVE 0x01

typedef struct {
    unsigned long mapDimensions[2];
    unsigned short *map;
    struct tilemapData **tiles;
    struct poweredObject **poweredObjects;
    int numChunks[1];
} Level;

typedef struct poweredObject {
    unsigned long position[2];
    struct powerNetInfo *powerNet;
} poweredObject;

typedef struct tilemapData {
    unsigned int flags;
} tilemapData;

typedef struct powerNetInfo {
    unsigned long objectsInNet;
} powerNetInfo;

Level *level;

void findSetPoweredObjects(unsigned long x, unsigned long y, powerNetInfo *powerNet) {
    // Look for poweredObjs on this tile and set their powerNet to the given powernet
    for (int i = 0; i < level->numChunks[0]; i++) {
        if (level->poweredObjects[i]->position[0] == x && level->poweredObjects[i]->position[1] == y) {
            level->poweredObjects[i]->powerNet = powerNet;
            powerNet->objectsInNet++;
        }
    }
}

void recursiveCheckTile(bool *isWalked, powerNetInfo *powerNet, long x, long y, tilemapData **levelMap) {
    // If out of bounds, return
    if (x < 0 || y < 0 || x >= level->mapDimensions[0] || y >= level->mapDimensions[1]) return;
    // If tile already walked, return
    if (isWalked[x + (y * level->mapDimensions[0])]) return;
    // If tile is nonconductive, return
    if (!(levelMap[x + (y * level->mapDimensions[0])]->flags & TILETYPE_CONDUCTIVE)) return;

    // Valid tile to check, see if there's a poweredobj on the tile (link it to the net if it is) and check the adjacent tiles.
    isWalked[x + (y * level->mapDimensions[0])] = true;

    findSetPoweredObjects(x, y, powerNet);

    // Recursively check adjacent tiles
    recursiveCheckTile(isWalked, powerNet, x - 1, y, levelMap);
    recursiveCheckTile(isWalked, powerNet, x + 1, y, levelMap);
    recursiveCheckTile(isWalked, powerNet, x, y - 1, levelMap);
    recursiveCheckTile(isWalked, powerNet, x, y + 1, levelMap);
}

bool buildPowerNets(void) {
    unsigned long mapSize = level->mapDimensions[0] * level->mapDimensions[1];
    bool *isWalked = (bool *)calloc(mapSize, sizeof(bool));
    if (!isWalked) return false; // Handle memory allocation failure

    // Example of initialization and usage
    powerNetInfo powerNet = {0};

    // Assuming (0, 0) is the starting point; adjust as necessary
    recursiveCheckTile(isWalked, &powerNet, 0, 0, level->tiles);

    free(isWalked); // Clean up memory allocation
    return true;
}

int main() {
    // Initialize level
    level = (Level *)malloc(sizeof(Level));
    level->mapDimensions[0] = 10;
    level->mapDimensions[1] = 10;
    level->numChunks[0] = 1;
    level->poweredObjects = (struct poweredObject **)malloc(sizeof(struct poweredObject *));
    level->poweredObjects[0] = (struct poweredObject *)malloc(sizeof(struct poweredObject));
    level->tiles = (struct tilemapData **)malloc(level->mapDimensions[0] * level->mapDimensions[1] * sizeof(struct tilemapData *));
    for (int i = 0; i < level->mapDimensions[0] * level->mapDimensions[1]; i++) {
        level->tiles[i] = (struct tilemapData *)malloc(sizeof(struct tilemapData));
        level->tiles[i]->flags = TILETYPE_CONDUCTIVE;
    }

    buildPowerNets();

    return 0;
}