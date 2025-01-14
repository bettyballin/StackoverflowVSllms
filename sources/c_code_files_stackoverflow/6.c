#include <stdio.h>

void adjust_gundeg(int objdeg, int* gundeg) {
    if (objdeg != *gundeg) {
        if ((*gundeg - objdeg) > 180) {
            (*gundeg)++;
        } else {
            (*gundeg)--;
        }
    }
}

int main() {
    int objdeg = 0;  // Example objective degree
    int gundeg = 270;  // Example gun degree
    
    printf("Before adjustment: gundeg = %d\n", gundeg);
    adjust_gundeg(objdeg, &gundeg);
    printf("After adjustment: gundeg = %d\n", gundeg);
    
    return 0;
}