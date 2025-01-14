#include <stdio.h>
#include <stdlib.h>

int main() {
    int extStatus1Id = 1;
    void* extStatus2Id = NULL;

    if (extStatus1Id == 1) {
        // Allow setting extStatus2Id
        extStatus2Id = malloc(sizeof(int));
    } else {
        // Ensure extStatus2Id is NULL
        extStatus2Id = NULL;
    }

    printf("extStatus2Id: %p\n", extStatus2Id);

    free(extStatus2Id);

    return 0;
}