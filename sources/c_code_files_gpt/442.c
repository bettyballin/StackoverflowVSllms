#include <stdio.h>
#include <stdlib.h>

// Example C structures and function prototype
typedef struct {
    int x;
    float y;
} InnerStruct;

typedef union {
    int a;
    float b;
} InnerUnion;

typedef struct {
    InnerStruct* innerStruct;
    InnerUnion* innerUnion;
} MainStruct;

void ProcessMainStruct(MainStruct* mainStruct) {
    // Example processing: just print the values
    printf("Inner Struct values: x = %d, y = %f\n", mainStruct->innerStruct->x, mainStruct->innerStruct->y);
    printf("Inner Union value (assuming int was last stored): a = %d\n", mainStruct->innerUnion->a);
}

int main() {
    // Dynamically allocate memory for inner structures to avoid stack variables going out of scope
    InnerStruct* innerStruct = (InnerStruct*)malloc(sizeof(InnerStruct));
    innerStruct->x = 10;
    innerStruct->y = 20.5;

    InnerUnion* innerUnion = (InnerUnion*)malloc(sizeof(InnerUnion));
    innerUnion->a = 30;

    MainStruct mainStruct;
    mainStruct.innerStruct = innerStruct;
    mainStruct.innerUnion = innerUnion;

    ProcessMainStruct(&mainStruct);

    // Clean up
    free(innerStruct);
    free(innerUnion);

    return 0;
}