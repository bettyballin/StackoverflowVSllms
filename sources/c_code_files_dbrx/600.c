#include <stdio.h>

void takes_a_long(long sad_story) {
    printf("%ld\n", sad_story);
}

int main() {
    float my_boat = 1.0f;
    long saad_story = 1;

#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wfloat-conversion"
    takes_a_long(my_boat); 
#pragma GCC diagnostic pop

    return 0;
}