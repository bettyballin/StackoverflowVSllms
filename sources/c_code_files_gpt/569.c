#include <osl/osl.h>
#include <stdbool.h>

OSL_IMAGE *background, *sprite, *bush;
int spritewidth, spriteheight, bushwidth, bushheight;
bool bushcol = false;

// Load images
void loadImages() {
    background = oslLoadImageFile("background.png", OSL_IN_RAM, OSL_PF_5551);
    sprite = oslLoadImageFile("sprite.png", OSL_IN_RAM, OSL_PF_5551);
    bush = oslLoadImageFile("bush.png", OSL_IN_RAM, OSL_PF_5551);

    // Set dimensions
    spritewidth = sprite->sizeX;
    spriteheight = sprite->sizeY;
    bushwidth = bush->sizeX;
    bushheight = bush->sizeY;
}

// Collision detection function
bool checkCollision(OSL_IMAGE* sprite, OSL_IMAGE* bush) {
    return (sprite->x + spritewidth > bush->x) &&
           (sprite->x < bush->x + bushwidth) &&
           (sprite->y + spriteheight > bush->y) &&
           (sprite->y < bush->y + bushheight);
}

// Update function to handle movements
void update() {
    bushcol = checkCollision(sprite, bush);

    if (osl_keys->held.down) {
        if (bushcol) {
            sprite->y = bush->y + bushheight;
        } else {
            sprite->y += 3;
        }
    }
    if (osl_keys->held.up) {
        if (bushcol) {
            sprite->y = bush->y - spriteheight;
        } else {
            sprite->y -= 3;
        }
    }
    if (osl_keys->held.right) {
        if (bushcol) {
            sprite->x = bush->x - spritewidth;
        } else {
            sprite->x += 3;
        }
    }
    if (osl_keys->held.left) {
        if (bushcol) {
            sprite->x = bush->x + bushwidth;
        } else {
            sprite->x -= 3;
        }
    }
}

int main() {
    // Initialize OSLib and load images
    oslInit(0);
    oslStartDrawing();

    loadImages();

    // Main game loop
    while (!osl_quit) {
        oslReadKeys();
        update();
        oslDrawImage(background);
        oslDrawImage(sprite);
        oslDrawImage(bush);
        oslEndFrame();
        oslSyncFrame();
    }

    // Cleanup
    oslDeleteImage(background);
    oslDeleteImage(sprite);
    oslDeleteImage(bush);
    oslEndGfx();
    oslQuit();

    return 0;
}