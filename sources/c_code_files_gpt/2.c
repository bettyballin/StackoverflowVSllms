#ifndef MYAPI_H
#define MYAPI_H

#ifdef __cplusplus
extern "C" {
#endif

struct MyType1;
struct MyType2;

typedef struct MyType1* MyType1Handle;
typedef struct MyType2* MyType2Handle;

// Function declarations
MyType1Handle CreateMyType1();
void DestroyMyType1(MyType1Handle handle);

MyType2Handle CreateMyType2();
void DestroyMyType2(MyType2Handle handle);

// Other function declarations...

#ifdef __cplusplus
}
#endif

#endif // MYAPI_H

// Implementations
struct MyType1 {
    int value;
};

struct MyType2 {
    float value;
};

MyType1Handle CreateMyType1() {
    MyType1Handle handle = malloc(sizeof(struct MyType1));
    handle->value = 0;
    return handle;
}

void DestroyMyType1(MyType1Handle handle) {
    free(handle);
}

MyType2Handle CreateMyType2() {
    MyType2Handle handle = malloc(sizeof(struct MyType2));
    handle->value = 0.0f;
    return handle;
}

void DestroyMyType2(MyType2Handle handle) {
    free(handle);
}

int main() {
    MyType1Handle type1 = CreateMyType1();
    MyType2Handle type2 = CreateMyType2();

    // Use the handles...

    DestroyMyType1(type1);
    DestroyMyType2(type2);

    return 0;
}