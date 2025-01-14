#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <pthread.h> // for posix_memalign

int main(void) {
    float *a;
    if (posix_memalign((void **)&a, 0x1000, 4 * sizeof(float)) != 0) {
        perror("posix_memalign");
        return 1;
    }

    a[0] = 1.0;
    a[1] = 2.0;
    a[2] = 3.0;
    a[3] = 4.0;

    printf("%p %p %p %p\n", (void *)&a[0], (void *)&a[1], (void *)&a[2], (void *)&a[3]);

    free(a);
    return 0;
}