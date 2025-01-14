#include <stdio.h>
#include <stdlib.h>

typedef struct {
    // I'm going to say x, y, is in the center
    int x;
    int y;
    int width;
    int height;
} Rect;

Rect newRect(int x, int y, int w, int h) {
    Rect r = {x, y, w, h};
    return r;
}

int rectsCollide(Rect *r1, Rect *r2) {
    if (r1->x + r1->width/2 < r2->x - r2->width/2) return 0;
    if (r1->x - r1->width/2 > r2->x + r2->width/2) return 0;
    if (r1->y + r1->height/2 < r2->y - r2->height/2) return 0;
    if (r1->y - r1->height/2 > r2->y + r2->height/2) return 0;
    return 1;
}

int main() {
    Rect r1 = newRect(100,200,40,40);
    Rect r2 = newRect(110,210,40,40);
    Rect r3 = newRect(150,250,40,40);

    if (rectsCollide(&r1, &r2))
        printf("r1 collides with r2\n");
    else
        printf("r1 doesn't collide with r2\n");

    if (rectsCollide(&r1, &r3))
        printf("r1 collides with r3\n");
    else
        printf("r1 doesn't collide with r3\n");

    return 0;
}