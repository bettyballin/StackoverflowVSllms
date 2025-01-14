#include <stdio.h>
#include <stdbool.h>

// Define a structure for texture
typedef struct {
    int width;
    int height;
} Texture;

int main() {
    // Initialize variables
    bool spanRight = false;
    int x = 10;
    Texture* tex = &(Texture){.width = 100, .height = 100};

    // Conditional statement
    if (!spanRight && x < tex->width) {
        printf("Condition met\n");
    } else {
        printf("Condition not met\n");
    }

    return 0;
}