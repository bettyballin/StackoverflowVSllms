#include <stdio.h>
#include <stdlib.h>

// Define a sprite structure
typedef struct {
    int x;
} Sprite;

int main() {
    const int tile_width = 32; // or something

    // Create a sprite
    Sprite* sprite = (Sprite*) malloc(sizeof(Sprite));
    sprite->x = 0;

    // and then
    sprite->x += tile_width;

    printf("Sprite x position: %d\n", sprite->x);

    // Free the allocated memory
    free(sprite);

    return 0;
}